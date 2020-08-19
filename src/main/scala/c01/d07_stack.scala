package main.scala.c01

import scala.io.StdIn

/**
  * ClassName d07_stack 
  * Description  
  *
  * @author WangRui
  * @date 2020/7/31
  * @time 9:16
  * @since JDK 1.8
  */
object d07_stack {

  def main(args: Array[String]): Unit = {
    val demo = new StackDemo(4)
    while (true) {
      val key = StdIn.readLine()
      key match {
        case "add" =>
          println("请输入值")
          val i = StdIn.readInt()
          demo.push(i)
        case "pop" =>
          val popValue = demo.pop()
          if (popValue.isInstanceOf[Int]) {

            println("值为：" + popValue)
          }
          else {
            println(popValue)
          }
        case "list" =>
          demo.list()
        case _ =>
          println("continue")

      }
    }


  }

  class StackDemo(maxSize: Int) {
    //定义数组来模拟栈
    private val array = new Array[Int](maxSize)
    var top: Int = -1

    //指针在栈顶
    def isFull(): Boolean = {
      top == maxSize - 1
    }

    //指针在栈低
    def isEmpty(): Boolean = {
      top == -1
    }

    def push(n: Int): Unit = {
      if (isFull()) {
        println("栈满---")
        return
      }
      top += 1
      array(top) = n
    }

    def pop(): Any = {
      if (isEmpty()) {
        throw new Exception("栈异常")
      }
      val value = array(top)
      top -= 1
      value

    }

    def list(): Unit = {
      if (isEmpty()) {
        println("栈空")
        return
      }
      for (i <- 0 to top reverse) {
        println(array(i))
      }
    }

    //优先级确定
    def priority(ch: Int): Int = {
      if (ch == '*' || ch == '/') {
        return 2
      } else if (ch == '-' || ch == '+') {
        return 1
      }
      -1
    }

    //计数规则
    def calculate(num1: Int, num2: Int, ch: Int): Int = {
      ch match {
        case '*' =>
          num1 * num2

        case '/' =>
          num2 / num2

        case '+' =>
          num1 + num2

        case '-' =>
          num2 - num1
      }
    }


  }

}
