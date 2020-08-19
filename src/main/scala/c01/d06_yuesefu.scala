package main.scala.c01

import scala.util.control.Breaks._

/**
  * ClassName d06_yuesefu 
  * Description  
  *
  * @author WangRui
  * @date 2020/7/30
  * @time 10:04
  * @since JDK 1.8
  */
object d06_yuesefu {
  def main(args: Array[String]): Unit = {
    val linkedBoy = new LinkedBoy
    linkedBoy.add(7)
    linkedBoy.list()
    println("-----开始玩耍----")
    linkedBoy.play(4, 3, 7)

  }

  class LinkedBoy() {
    //保证第一个不能动
    var first = new Boy(-1)

    def add(num: Int): Unit = {
      //辅助指针，实现环形
      var curBoy: Boy = null
      for (i <- 1 to num) {
        val boy = new Boy(i)
        if (boy.no == 1) {
          //形成第一个环
          first = boy
          boy.next = first
          //辅助指针指向第一个节点
          curBoy = first
        } else {
          //加入的节点形成环
          curBoy.next = boy
          boy.next = first
          //辅助指针指向新加入的节点
          curBoy = boy
        }
      }
    }

    //遍历结构
    def list(): Unit = {
      if (first.next == null) {
        println("没有元素可以遍历")
      }
      var boy = first
      breakable {
        while (true) {
          println("boy-" + boy.no)
          //循环一周后，最后一个节点的next指向第一个
          if (boy.next == first) {
            break()
          }
          boy = boy.next
        }
      }
    }

    //功能：玩的规则 思路：1.辅助指针放到first的前面，2.把first移到要开始数的位置上
    def play(startNo: Int, countNum: Int, all: Int): Unit = {
      if (startNo < 0 | startNo > all || countNum > all) {
        println("没法玩")
        return
      }
      //定义一个辅助指针，指向first的上一个节点
      var helper = first
      //1.定位helper指针
      breakable(
        while (true) {
          if (helper.next == first) {
            break()
          }
          helper = helper.next
        }
      )
      //2.确定first开始的位置
      for (i <- 1 until startNo) {
        first = first.next
        helper = helper.next
      }
      //3.开始出圈
      breakable(
        while (true) {
          //只剩一个元素退出
          if (helper == first) {
            break()
          }
          //开始遍历，first循环之后到要出圈的位置
          for (i <- 1 until countNum) {
            first = first.next
            helper = helper.next
          }
          println("boy-" + first.no)
          //first指向的位置出圈
          first = first.next
          helper.next = first
        }
      )
      println("last boy go-" + first.no)
    }
  }

  class Boy(n: Int) {
    val no: Int = n
    var next: Boy = null
  }

}
