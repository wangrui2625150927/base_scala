package main.scala.c01

import scala.util.control.Breaks._

/**
  * ClassName d09_hashTableDemo 
  * Description  
  *
  * @author WangRui
  * @date 2020/7/31
  * @time 20:11
  * @since JDK 1.8
  */
object d09_hashTableDemo {
  def main(args: Array[String]): Unit = {
    val list = new hashTabke(7)
    list.addList(new Emp(23, "q"))
    list.addList(new Emp(22, "q"))
    list.addList(new Emp(2, "w"))
    list.addList(new Emp(13, "r"))
    list.list()
    //println(list.findList(1))


  }

  //思路：熟悉哈希加散列的结构 哈希表里面放多条链表，链表里面放多个元素
  //1.定义基本类
  class Emp(id: Int, name: String) {
    val no = id
    val en = name
    var next: Emp = null
  }

  //2.定义链表
  class LinkedList {
    var head: Emp = null

    //思路：找到最后一个元素加入进去
    def addEmp(emp: Emp): Unit = {
      //第一次添加 把值赋值给head
      if (head == null) {
        head = emp
        return
      }
      //定义辅助指针 指向head
      var cur = head
      breakable(
        while (true) {
          if (cur.next == null) {
            break()
          }
          if(cur.next.no>emp.no){
            emp.next = cur.next
            break()
          }
          cur = cur.next
        }
      )
      cur.next = emp
    }

    def listEmp(): Unit = {
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
          print("id=>" + cur.no + "--" + cur.en + "\t")
          cur = cur.next
        }

      )
      println()
    }

    def findEmp(id: Int): Emp = {
      if (head == null) {
        return null
      }
      var cur = head
      breakable(
        while (true) {
          if (cur == null) {
            break()
          }
          if (cur.no == id) {
            break()
          }
          cur = cur.next

        }
      )
      cur

    }

  }

  class hashTabke(maxSiz: Int) {
    private var array = new Array[LinkedList](maxSiz)
    for (i <- 0 until array.size) {
      array(i) = new LinkedList()
    }

    def addList(emp: Emp): Unit = {
      val i = hashFun(emp.no)
      array(i).addEmp(emp)
    }

    def list(): Unit = {
      for (elem <- array) {
        elem.listEmp()
      }
    }

    def hashFun(id: Int): Int = {
      id % maxSiz
    }

    def findList(id: Int): Emp = {
      val i = hashFun(id)
      array(i).findEmp(id)
    }
  }


}
