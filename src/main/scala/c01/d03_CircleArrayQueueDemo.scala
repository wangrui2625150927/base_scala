package main.scala.c01

import scala.io.StdIn

/**
  * ClassName d03_CircleArrayQueueDemo 
  * Description  
  *
  * @author WangRui
  * @date 2020/7/27
  * @time 20:31
  * @since JDK 1.8
  */
object d03_CircleArrayQueueDemo {
  def main(args: Array[String]): Unit = {
    val array = new CircleArrayQueue(3)
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

  //会留有一个空间存放指针，长度为3的数组，只能存2个元素
  class CircleArrayQueue(maxSize: Int) {
    //初始化操作
    private val array = new Array[Int](maxSize)
    var front = 0
    var rear = 0

    //判断队列满
    def isFull(): Boolean = {
      //结合添加元素方法分析
      (rear + 1) % maxSize == front
    }

    //判断队列空
    def isEmpty(): Boolean = {
      //元素取完，front移到最后
      front == rear
    }

    //添加元素
    def addQueue(n: Int): Unit = {
      if (isFull()) {
        println("---队列满---")
        return
      }
      array(rear) = n
      //0 1
      //2
      rear = (rear + 1) % maxSize
    }

    //获取元素
    def getQueue(): Any = {
      if (isEmpty()) {
        new Exception("队列空")
      }
      val value = array(front)
      front = (front + 1) % maxSize
      value
    }

    //遍历元素
    def printQueue(): Unit = {
      if (isEmpty()) {
        println("---队列为空---")
        return
      }
      //左闭右开
      for (i <- front until front + count()) {
        printf("arr[%d]=%d", i % maxSize, array(i % maxSize))
      }
    }

    def count(): Int = {
      //经验算法，可以直接代数验证
      (rear + maxSize - front) % maxSize
    }
  }

}
