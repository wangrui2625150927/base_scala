package main.scala.c02

import scala.io.StdIn

/**
  * ClassName d03CircleQueue 
  * Description  
  *
  * @author WangRui
  * @date 2020/8/1
  * @time 12:00
  * @since JDK 1.8
  */
object d03CircleQueue {

  def main(args: Array[String]): Unit = {
    val arr = new CircleQueue(3)
    while (true) {

      println("add----")
      println("get----")
      println("list----")
      println("break")
      println("请选择---")
      val key = StdIn.readLine()
      key match {
        case "add" =>
          print("请添加元素：")
          val n = StdIn.readInt()
          arr.add(n)

        case "get" =>
          println(arr.get())

        case "list" =>
          arr.list()

        case "break" =>
          System.exit(0)
        case _ =>
          println("请重新输入----")

      }
    }
  }

  //思路分析 ：环形队列用数组实现
  //1.队满情况 (rear+1)% maxSize == front
  //2.队空情况 front == rear
  class CircleQueue(maxSize: Int) {
    private val array = new Array[Int](maxSize)
    //初始化指针
    var front = 0
    var rear = 0

    def isFull(): Boolean = {
      (rear + 1) % maxSize == front
    }

    def isEmpty(): Boolean = {
      //front指针移到最后
      front == rear
    }

    def add(n: Int): Unit = {
      if (isFull()) {
        println("循环队列满--")
        return
      }
      //rear指针后移
      array(rear) = n
      rear = (rear + 1) % maxSize
    }

    def get(): Int = {
      if (isEmpty()) {
        println("循环队列为空")
        return -1
      }
      //从头取元素
      val value = array(front)
      front = (front + 1) % maxSize
      value

    }

    def count(): Int = {
      (rear + maxSize - front) % maxSize
    }

    def list(): Unit = {
      if (isEmpty()) {
        println("循环队列为空")
        return
      }
      for (i <- front until front + count()) {
        //取数的时候也要按%来取
        printf("arr[%d]=%d",i%maxSize,array(i%maxSize))
      }
      println()
    }
  }

}
