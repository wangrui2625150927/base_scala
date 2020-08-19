package main.scala.c01

import scala.collection.mutable.ArrayBuffer

/**
  * ClassName d01_ParseArray 
  * Description  数组压缩
  *
  * @author WangRui
  * @date 2020/7/27
  * @time 13:36
  * @since JDK 1.8
  */
object d01_ParseArray {
  def main(args: Array[String]): Unit = {
    //1.定义稀疏数组
    val cheerMaps = Array.ofDim[Int](11, 11)
    cheerMaps(1)(2) = 1
    cheerMaps(2)(3) = 2
    cheerMaps(2)(3) = 3

    //2.查看数组显示
    println("----原始数组打印----")
    printArray(cheerMaps)

    //3.进行压缩 思路：class Node()里面存放压缩信息,把Node对象放到ArrayBuffer中
    val nodesToNodes = new ArrayBuffer[Node]
    nodesToNodes.append(new Node(11, 11, 0))

    for (i <- cheerMaps.indices) {
      for (j <- cheerMaps(i).indices) {
        if (cheerMaps(i)(j) != 0) {
          val node = new Node(i, j, cheerMaps(i)(j))
          nodesToNodes.append(node)
        }
      }
    }

    //4.压缩显示
    println("----压缩数组打印----")
    for (elem <- nodesToNodes) {
      println(elem.row + "\t" + elem.col + "\t" + elem.value)
    }

    //4.压缩数据回显 思路：对压缩数组进行遍历，为新的数组赋值
    val array = Array.ofDim[Int](11, 11)
    for (i <- 1 until nodesToNodes.length) {
      val node = nodesToNodes(i)
      array(node.row)(node.col) = node.value
    }
    println("----压缩数组回显----")
    printArray(array)
  }
/**
 * Description 功能：打印数组
 * @author WangRui
 * @date 2020/7/27
 * @time 14:26
 * @param Array[Array[Int] 二维数组
 * @return nothing
 */

  private def printArray(cheerMaps: Array[Array[Int]]) = {
    for (elem <- cheerMaps) {
      for (elem <- elem) {
        print(elem + "\t")
      }
      println()
    }
  }

  class Node(val row: Int, val col: Int, val value: Int)


}
