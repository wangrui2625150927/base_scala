package main.scala.c01

import scala.io.StdIn

/**
  * ClassName ArrayQueueDemo 
  * Description  数组模拟队列
  *
  * @author WangRui
  * @date 2020/7/27
  * @time 15:47
  * @since JDK 1.8
  */
object d02_ArrayQueueDemo {
  def main(args: Array[String]): Unit = {
    val array = new QueueArray(3)
    while (true) {
      println("show----")
      println("add----")
      println("get----")
      println("break")
      println("请选择---")
      val key = StdIn.readLine()
      key match {
        case "show" =>
          array.printQueue()
        case "add" =>
          println("请输入值")
          val i = StdIn.readInt()
          array.addQueue(i)
        case "get" =>
          val queue = array.getQueue()
          if (queue.isInstanceOf[Exception]) {
            println(queue.asInstanceOf[Exception])
          } else {
            println(queue)
          }
        case "break" =>
          System.exit(0)
        case _ =>
          println("重新输入")
      }
    }
  }

  //定义一个队列，用数组来模拟
  class QueueArray(maxsize: Int) {
    val arr = new Array[Int](maxsize)
    var front = -1
    var rear = -1

    def isFull(): Boolean = {
      //rear指针移到最后，说明队列满
      rear == maxsize - 1
    }

    def isEmpty(): Boolean = {
      //front指针移到最后，说明队列空
      front == rear
    }

    def addQueue(n: Int): Unit = {
      if (isFull()) {
        println("---队列满---")
        return
      }
      rear += 1
      arr(rear) = n
    }

    def getQueue(): Any = {
      if (isEmpty()) {
        new Exception("队列空")
      }
      front += 1
      arr(front)
    }

    def printQueue(): Unit = {
      if (isEmpty()) {
        println("---队列为空---")
        return
      }
      //因为front初始化为-1，所以要+1操作
      for (i <- front + 1 to rear) {
        println(arr(i) + "\t")
      }
    }
  }
}
