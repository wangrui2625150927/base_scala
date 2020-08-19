package main.scala.c01

import scala.util.control.Breaks._

/**
  * ClassName d04_SingleLinkedList 
  * Description  
  *
  * @author WangRui
  * @date 2020/7/28
  * @time 21:00
  * @since JDK 1.8
  */
object d04_SingleLinkedList {

  def main(args: Array[String]): Unit = {
    val singleLinkedList = new SingleLinkedList()
//    println("------------无序插入--------------")
    ////    singleLinkedList.add(new HeroNode(1, "a"))
    ////    singleLinkedList.add(new HeroNode(4, "b"))
    ////    singleLinkedList.add(new HeroNode(3, "c"))
    ////    singleLinkedList.list()
    println("------------有序插入----------------")
    val singleLinkedList1 = new SingleLinkedList()
    singleLinkedList1.add2(new HeroNode(1, "a"))
    singleLinkedList1.add2(new HeroNode(4, "d"))
    singleLinkedList1.add2(new HeroNode(3, "c"))
    singleLinkedList1.add2(new HeroNode(2, "b"))
    singleLinkedList1.list()
    println("------------更新值-----------------")
    singleLinkedList1.update(new HeroNode(4, "f"))
    singleLinkedList1.list()
    println("------------删除值-----------------")
    singleLinkedList1.del(3)
    singleLinkedList1.list()

  }

  class SingleLinkedList {
    //初始化操作，定义头结点
    val head = new HeroNode(0, "")

    //功能：删除值 思路找到no进行删除
    def del(n:Int): Unit ={
      var temp = head
      var flag =false
      breakable(
        while (true){
          if (temp==null){
            break()
          }
          if (temp.next.no== n){
            flag = true
            temp.next = temp.next.next
            break()
          }
          temp = temp.next
        }
      )
      if (!flag){
        println("节点找不到")
      }

    }

    //功能：修改值 思路：先找到no相等的，再进行值的替换
    def update(heroNode: HeroNode): Unit ={
      var temp =head
      //定义一个标记位，表示更新的点是否存在
      var flag =false
      breakable(
        while (true){
          if (temp == null){
            break()
          }
          if (temp.next.no == heroNode.no){
            flag = true
            temp.next.name = heroNode.name
            break()
          }
          temp = temp.next
        }
      )
      if (!flag){
        println("没有找到更新的节点")
      }
    }

    //添加操作,强调头结点不能动，这里采用尾插法，不考虑次序
    def add(heroNode: HeroNode): Unit = {
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
          if (temp == null) {
            break()
          }
          println("id:" + temp.no + "name:" + temp.name)
          temp = temp.next
        }
      }
    }

    //功能：有序插入  思路：插入的过程是一个比较的过程
    def add2(heroNode: HeroNode): Unit = {
      var temp = head
      //这个变量来查看插入的节点是否存在
      var flag = false
      breakable {
        while (true) {
          //第一次直接插入，所以退出
          if (temp.next == null) {
            break()
          }
          //这种情况，插入在temp的后面
          if (temp.next.no > heroNode.no) {
            //断开节点时，先从后面断
            heroNode.next = temp.next
            break()
          }
          if (temp.next.no == heroNode.no) {
            flag = true
          }
          //遍历查找no大的节点
          temp = temp.next

        }
      }
      if (!flag) {

        temp.next = heroNode
      } else {
        println("节点存在")
      }


    }

  }

  class HeroNode(num: Int, hname: String) {
    var no: Int = num
    var name: String = hname
    var next: HeroNode = null

  }


}

