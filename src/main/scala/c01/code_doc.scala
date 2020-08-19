package main.scala.c01

import scala.io.StdIn


object code_doc {
  /**
   * Description
   * @author WangRui
   * @date 2020/7/27
   * @time 10:42
   * @param
   * @return
   */
  def main(args: Array[String]): Unit = {
    var a = new Array[Int](10)
    a.foreach(x => a)
    println(a + "\t")
    println("请输入：")
    val i = StdIn.readInt()
    val name = StdIn.readLine()
    println(name+"--"+i)


  }

  /**
   * Description
   * @author WangRui
   * @date 2020/7/27
   * @time 10:51
   * @param  a:Int, b:Int
   * @return Int
   */
  def test(a:Int,b:Int):Int = {
    return a+b
  }


}
