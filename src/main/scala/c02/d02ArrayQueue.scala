package main.scala.c02

import scala.io.StdIn

/**
  * ClassName d02ArrayQueue 
  * Description  
  *
  * @author WangRui
  * @date 2020/8/1
  * @time 10:51
  * @since JDK 1.8
  */
object d02ArrayQueue {
  def main(args: Array[String]): Unit = {
    val arr = new ArraryQueueDemo(30)
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

        case "get"=>
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

  //思路：队列先进先出，用数组实现，
  //队满情况 rear ==maxsize -1
  //队空情况 first == rear
  class ArraryQueueDemo(maxSize:Int){
    private val array = new Array[Int](maxSize)
    //初始化指针
    var front = -1
    var rear = -1

    def isFull(): Boolean ={
      rear == maxSize - 1
    }

    def isEmpty(): Boolean ={
      front == rear
    }

    def add(n:Int): Unit ={
      if (isFull()){
        println("队列满--")
       return
      }
      //rear指针后移
      rear+=1
      array(rear) = n
    }

    def get(): Int ={
      if (isEmpty()){
        println("队列空")
        return 0
      }
      //front指针后移
      front += 1
      array(front)
    }

    def list(): Unit ={
      if (isEmpty()){
        println("没有元素--")
      }
      for (i <- front+1 to rear){
      print(array(i)+"\t")
      }
      println()
    }
  }

}
