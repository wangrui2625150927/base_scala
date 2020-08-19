package main.scala.c02

/**
  * ClassName d09hashTableDemo 
  * Description  
  *
  * @author WangRui
  * @date 2020/8/4
  * @time 11:04
  * @since JDK 1.8
  */

import scala.util.control.Breaks._

object d09hashTableDemo {
  def main(args: Array[String]): Unit = {
//    val list = new LinkedList
//    val node1 = new Node(1)
//    val node11 = new Node(0)
//    val node2 = new Node(3)
//    val node3 = new Node(5)
//    val node4 = new Node(9)
//    val node5 = new Node(7)
//
//    list.add(node1)
//    list.add(node11)
//    list.add(node2)
//    list.add(node3)
//    list.add(node4)
//    list.add(node5)
//    println(list.findId(10))
//    list.list()

    val table = new HashTable(5)
    table.add(new Node(2))
    table.add(new Node(5))
    table.add(new Node(4))
    println("遍历查找")
    table.list()
    println("查找id 5")
    println(table.findId(5))
    println("查找id 10")
    println(table.findId(10))

  }

  //思路：熟悉经典哈希表结构 哈希表 -》链表 -》节点
  //1.定义节点
  class Node(id: Int) {
    var no = id
    var next: Node = null
  }

  //2.定义链表，头结点指向第一个节点
  class LinkedList {
    var head: Node = null

    def add(node: Node): Unit = {
      if (head == null) {
        head = node
        return
      }
      //定义辅助指针
      var cur = head
      breakable(
        while (true) {
          if (cur.no > node.no) {
            var temp = cur.no
            cur.no = node.no
            node.no = temp

            break()
          }
          if (cur.next == null) {
            break()
          }
          cur = cur.next
        }
      )
      cur.next = node
    }


    def list(): Unit = {
      if (head == null) {
        println("没有元素可以遍历")
        return
      }
      var cur = head
      breakable(
        while (true) {

          if (cur == null) {
            break()
          }
          print("id=>" + cur.no + "\n")
          cur = cur.next
        }
      )
    }

    def findId(id: Int): Node = {
      if (head == null) {
        println("没有元素可以查找")
        return null
      }
      var result: Node = null
      var cur = head
      breakable(
        while (true) {
          if (cur == null) {
            break()
          }
          if (cur.no == id) {
            result = cur
            break()
          }
          cur = cur.next
        }
      )
      if (result == null) {
        println("没有找到要查找的值")
        return null
      }
      result

    }

  }

  class HashTable(size: Int) {
    private val array = new Array[LinkedList](size)
    for (i <- 0 until size) {
      array(i) = new LinkedList
    }

    def add(node: Node): Unit = {
      val i = hashFun(node.no)
      array(i).add(node)
    }

    def list(): Unit = {
      for (elem <- array) {
        elem.list()
      }
    }

    def findId(id: Int): Node = {
      val i = hashFun(id)
      return array(i).findId(id)

    }

    def hashFun(id: Int): Int = {
      id % size
    }

  }

}
