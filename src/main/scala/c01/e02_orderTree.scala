package main.scala.c01

/**
  * ClassName e02_orderTree 
  * Description  
  *
  * @author WangRui
  * @date 2020/8/2
  * @time 15:40
  * @since JDK 1.8
  */
object e02_orderTree {
  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 3, 4, 5, 6, 7)
    val tree = new OrderTree(array)
    tree.preOrder()
  }

  class OrderTree(array: Array[Int]) {
    def preOrder(): Unit ={
      this.preOrder(0)
    }
    def preOrder(index: Int): Unit = {
      if (array == null || array.length == 0) {
        println("数组为空")
        return
      }
      println(array(index))
      if ((index * 2 + 1) < array.length) {
        this.preOrder(index * 2 + 1)
      }
      if (index * 2 + 2 < array.length) {
        this.preOrder(index * 2 + 2)
      }
    }
  }

}
