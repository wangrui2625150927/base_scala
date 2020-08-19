package main.scala.c02

import scala.io.StdIn
import scala.util.control.Breaks._

/**
  * ClassName d04SingleLinkedList 
  * Description  
  *
  * @author WangRui
  * @date 2020/8/1
  * @time 12:48
  * @since JDK 1.8
  */
object d04SingleLinkedList {
  def main(args: Array[String]): Unit = {
    val arr = new LinkedList
    val node1 = new Node(1, "a")
    val node2 = new Node(3, "c")
    val node3 = new Node(2, name = "b")
    arr.add(node1)
    arr.add(node2)
    arr.add(node3)
    println("第一次遍历")
    arr.list()
    arr.del(1)
    println("删除1")
    arr.list()
    arr.del(3)
    println("删除3")
    arr.list()
  }

  //思路分析：
  //1.设置一个节点 封装数据和指针等信息
  //2.头结点初始化Node类型，值为null
  class Node(id: Int, name: String) {
    var no = id
    var nm = name
    var next: Node = null

  }

  class LinkedList() {
    //初始化头结点
    val head: Node = new Node(-1, "")

    def add(node: Node): Unit = {
      //定义辅助指针
      var temp = head
      //如果flag变为true，则说明找到相等的，不进行插入操作
      var flag = false
      breakable(
        while (true) {
          if (temp.next == null) {
            break()
          }
          if (temp.next.no > node.no) {
            //当前新加入的节点放在temp.next指向的节点前面
            node.next = temp.next
            break()
          }
          if (temp.next.no == node.no) {
            flag = true
          }
          temp = temp.next
        }
      )
      if (flag) {
        println("插入节点相同")
        return
      }
      temp.next = node
    }

    def del(id: Int): Unit = {
      if (head.next == null) {
        println("无节点可以删除--")
        return
      }
      var temp = head
      //定义删除的标记位
      var flag = false
      breakable(
        while (true) {
          if (temp == null) {
            flag = true
            break()
          }
          if (temp.next.no == id) {
            temp.next = temp.next.next
            break()
          }

          temp = temp.next
        }
      )
      if (flag) {
        println("没有元素可以删除")
      }
    }

    def list(): Unit = {
      if (head.next == null) {
        println("无节点可以遍历--")
        return
      }
      var temp = head.next
      breakable(
        while (true) {
          if (temp == null) {
            break()
          }
          println(temp.no + "\t" + temp.nm)
          temp = temp.next
        }
      )
    }
  }

}






