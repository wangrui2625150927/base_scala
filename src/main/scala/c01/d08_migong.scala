package main.scala.c01

/**
  * ClassName d08_migong 
  * Description  
  *
  * @author WangRui
  * @date 2020/7/31
  * @time 13:28
  * @since JDK 1.8
  */
object d08_migong {
  def main(args: Array[String]): Unit = {
    //思路分析：
    /*    1.定义地图
          2.标注围墙
          3.设置阻碍
          4.规则说明 0表示还没有的走路 1表示围墙 2表示可以走的路 3表示已走过，但是走不通
          5.按照下右上左的原理走*/

    //1.定义地图
    val array = Array.ofDim[Int](8, 7)
    //2.上下围墙
    for (i <- 0 until 7) {
      array(0)(i) = 1
      array(7)(i) = 1
    }
    //左右围墙
    for (i <- 0 until 8) {
      array(i)(0) = 1
      array(i)(6) = 1
    }
    array(3)(1) = 1
    array(4)(1) = 1
    array(1)(2) = 1
    array(2)(2) = 1
    array(3)(2) = 1
    for (elem <- array) {
      for (elem <- elem) {
        print(elem + "\t")
      }
      println()
    }
    println("----------------")
    setWay(array,2,1)
    for (elem <- array) {
      for (elem <- elem) {
        print(elem + "\t")
      }
      println()
    }

  }
//思路：先确定一个出口
//  假设这个点的路可以走 然后按照下-》右-》上-》左的思路开始走
//  如果这个点能走就设为2，负责设为3，
  def setWay(map: Array[Array[Int]], i: Int, j: Int): Boolean = {

    if (map(6)(5) == 2) {
      true
    }
    else {
      if (map(i)(j) == 0) {
        //假定路可以走
        map(i)(j) = 2
        if (setWay(map, i + 1, j)) {
           true
        } else if (setWay(map, i, j + 1)) {
           true
        } else if (setWay(map, i - 1, j)) {
           true
        } else if (setWay(map, i, j - 1)) {
          true
        } else {
          //走不通
          map(i)(j) = 3
           false
        }
      }else{
       false
      }
    }


  }

}
