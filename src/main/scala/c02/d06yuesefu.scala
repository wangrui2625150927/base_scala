package main.scala.c02

/**
  * ClassName d06yuesefu 
  * Description  
  *
  * @author WangRui
  * @date 2020/8/1
  * @time 16:12
  * @since JDK 1.8
  */
object d06yuesefu {
  def main(args: Array[String]): Unit = {
    val list = new CircleList
    list.add(7)
    list.list()
    println("---开始玩耍---")
    list.play(4,3,7)
  }

  class Boy(id: Int) {
    val no = id
    var next: Boy = null
  }

  class CircleList() {
    //定义头结点


    var first: Boy = new Boy(-1)
    var curBoy: Boy = null

    def add(num: Int): Unit = {
      //循环赋值，再往里面加元素
      for (i <- 1 to num) {
        val boy = new Boy(i)
        if (first.next == null) {
          first = boy
          boy.next = first
          curBoy = first
        } else {
          curBoy.next = boy
          boy.next = first
          curBoy = boy
        }
      }
    }

    import scala.util.control.Breaks._

    def list(): Unit = {
      var temp = first
      breakable(
        while (true) {
          println("boy-->" + temp.no)
          if (temp.next == first) {
            break()
          }
          temp = temp.next
        }
      )
    }



    def play(startNum: Int, count: Int, all: Int): Unit = {
      var helper: Boy =first
      //定义一个辅助指针
      breakable(
        while (true) {
          if (helper.next == first) {
            break()
          }
          helper = helper.next
        }
      )
      //辅助指针一直在first的前面
      //1.找到开始的位置
      for (i <- 1 until startNum) {
        first = first.next
        helper = helper.next
      }
      //2.开始计数
      breakable(
        while (true) {
          if (helper == first) {
            break()
          }
          for (i <- 1 until count) {
            first = first.next
            helper = helper.next
          }
          println("boy-->" + first.no)
          first = first.next
          helper.next = first
        }
      )
      println("boy-->" + first.no)
    }
  }

}