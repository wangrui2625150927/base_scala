package main.scala.c02

/**
  * ClassName d05_DoubleLinkedList 
  * Description  
  *
  * @author WangRui
  * @date 2020/8/1
  * @time 15:06
  * @since JDK 1.8
  */
import scala.util.control.Breaks._
object d05DoubleLinkedList {
  def main(args: Array[String]): Unit = {
    val list = new DoubleLinkedList
    val node1 = new Node(1,"a")
    val node2 = new Node(2,"b")
    val node3 = new Node(3,"c")
    list.add(node1)
    list.add(node2)
    list.add(node3)
    println("1--------")
    list.list()
    println("3--------")
    list.del(3)
    list.list()


  }
  class Node(id:Int,name: String){
    val no =id
    val ne = name
    var pre:Node = null
    var next:Node = null
  }


  class DoubleLinkedList{
    var head :Node =new Node(-1,"")
    //加入元素和单链表一样，在后面插入元素
    def add(node: Node): Unit ={
      var temp =head
      breakable(
        while (true){
        if(temp.next == null){
          break()
        }
          temp = temp.next
        }
      )
      temp.next = node
      node.pre = temp
    }

    def del(id:Int): Unit ={
      if (head.next == null){
        println("没有元素")
        return
      }
      var temp = head.next
      breakable(
        while (true){
          if (temp ==null){
            break()
          }
          if (temp.no==id){
            temp.pre.next = temp.next
            if (temp.next!=null){
              temp.next.pre = temp.pre
            }

            break()
          }
          temp = temp.next
        }
      )
    }

    def list(): Unit ={
      if (head.next == null){
        println("没有元素")
        return
      }
      var temp =head.next
      breakable(
        while (true){
          //边界条件把握
          if (temp == null){
            break()
          }
          println(temp.no+"\t"+temp.ne)
          temp =temp.next
        }
      )
    }
  }
}
