package main.scala.c01


import scala.util.control.Breaks.{break, breakable}

/**
  * ClassName d05_DoubleLinkedList 
  * Description  
  *
  * @author WangRui
  * @date 2020/7/29
  * @time 20:35
  * @since JDK 1.8
  */
object d05_DoubleLinkedList {
  def main(args: Array[String]): Unit = {
    val linkedList = new DoubleLinkedList
    var hero1 = new HeroNode1(1, "a")
    var hero2 = new HeroNode1(2, "a")
    var hero3 = new HeroNode1(3, "a")
    var hero4 = new HeroNode1(4, "a")
    linkedList.add(hero1)
    linkedList.add(hero2)
    linkedList.add(hero3)
    linkedList.add(hero4)
    println("------------无序插入--------------")
    linkedList.list()
    println("------------删除值-----------------")
    linkedList.del(2)
    linkedList.del(3)
    linkedList.del(4)
    linkedList.add(hero3)
    linkedList.list()
  }

  class DoubleLinkedList {
    val head = new HeroNode1(0, "")

    //添加操作,强调头结点不能动，这里采用尾插法，不考虑次序
    //功能：删除值 思路找到no进行删除
    def del(n: Int): Unit = {
      var temp = head.next
      var flag = false
      breakable(
        while (true) {
          if (temp == null) {
            break()
          }
          if (temp.no == n) {
            flag = true

            break()
          }
          temp = temp.next
        }
      )
      if (!flag) {
        println("节点找不到")
      } else {
        temp.pre.next = temp.next
        //若删除的是最后一个节点，则需要判空
        if (temp.next != null) {
          temp.next.pre = temp.pre
        }
      }

    }

    def add(heroNode: HeroNode1): Unit = {
      var temp = head
      //1.先找到最后一个节点
      breakable {
        while (true) {
          if (temp.next == null) {
            break()
          }
          temp = temp.next
        }
      }
      //2.最后一个节点的next指向下一个元素
      temp.next = heroNode
      heroNode.pre = temp
    }

    def list(): Unit = {
      //没有元素则直接退出
      if (head.next == null) {
        println("没有元素可以遍历")
        return
      }
      var temp = head.next
      breakable {
        while (true) {
          //注意边界条件
          if (temp == null) {
            break()
          }
          println("id:" + temp.no + "name:" + temp.name)
          temp = temp.next
        }
      }
    }
  }

  class HeroNode1(num: Int, hname: String) {
    var no: Int = num
    var name: String = hname
    var pre: HeroNode1 = null
    var next: HeroNode1 = null

  }

}
