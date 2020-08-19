package main.scala.c02

/**
  * ClassName e03OrderBinaeryTree 
  * Description  
  *
  * @author WangRui
  * @date 2020/8/4
  * @time 16:06
  * @since JDK 1.8
  */
object e03OrderBinaeryTree {
  def main(args: Array[String]): Unit = {
    val array = Array(7, 4, 3, 2, 9, 10, 5, 6, 8)
    val tree = new BinaeryTree
    for (i <- array.indices) {
      tree.add(new Node(array(i)))
    }
    tree.list()
    println()
    println(tree.search(5).no)
    println(tree.searchParent(2).no)
    println("删除测试 7 ")
    tree.del(7)
    tree.list()
    println("删除测试 3 ")
    tree.del(3)
    tree.list()

  }

  class Node(id: Int) {
    var no = id
    var left: Node = null
    var right: Node = null

    def add(node: Node): Unit = {
      if (node == null) {
        return
      }
      if (this.no < node.no) {
        if (this.right == null) {
          this.right = node
        } else {
          this.right.add(node)
        }
      } else {
        if (this.left == null) {
          this.left = node
        } else {
          this.left.add(node)
        }
      }
    }

    def search(id: Int): Node = {
      if (this.no == id) {
        return this
      }
      if (this.no < id) {
        if (this.right != null) {
          this.right.search(id)
        } else {
          null
        }
      } else {
        if (this.left != null) {
          this.left.search(id)
        } else {
          null
        }
      }
    }

    def searchParent(id: Int): Node = {
      if (this.left != null && this.left.no == id || this.right != null && this.right.no == id) {
        return this
      }
      if (this.left != null && this.no > id) {
        return this.left.searchParent(id)
      }
      if (this.right != null && this.no < id) {
        return this.right.searchParent(id)
      }
      null
    }

    def findMinvalue(node: Node): Int = {
      var temp = node
      while (temp.left != null) {
        temp = temp.left
      }
      del(temp.no)
      temp.no
    }

    def del(id: Int): Unit = {
      val node = search(id)
      if (node == null) {
        println("没有节点可以删")
      }
      val parentNode = searchParent(id)
      //1.删除的节点是叶子节点
      //2.删除的节点有两个子节点
      //3.删除的节点有一个节点
      if (node.left == null && node.right == null) {
        if (parentNode.left.no == id) {
          parentNode.left = null
        } else {
          parentNode.right = null
        }
      } else if (node.left != null && node.right != null) {
        val i = findMinvalue(node.right)
        node.no = i
      } else {
        if (node.left != null) {
          if (parentNode.left != null && parentNode.left.no == node.no) {
            parentNode.left = node.left
          } else {
            parentNode.right = node.left
          }
        } else {
          if (parentNode.left != null && parentNode.left.no == node.no) {
            parentNode.left = node.right
          } else {
            parentNode.right = node.right
          }
        }
      }

    }

    def list(): Unit = {
      if (this.left != null) {
        this.left.list()
      }
      print("id => " + this.no + "\t")
      if (this.right != null) {
        this.right.list()
      }
    }
  }

  //定义树状结构
  class BinaeryTree {
    var root: Node = null

    def add(node: Node): Unit = {
      if (root == null) {
        root = node
      } else {
        root.add(node)
      }
    }

    def del(id:Int): Unit ={
      if (root!=null){
        root.del(id)
      }
    }

    def list(): Unit = {
      if (root != null) {
        root.list()
      } else {
        println("无元素遍历")
      }
    }

    def search(id: Int): Node = {
      if (root == null) {
        println("列表为空，无法查找")
        null
      } else {
        root.search(id)
      }
    }

    def searchParent(id: Int): Node = {
      if (root == null) {
        println("列表为空，无法查找")
        null
      } else {
        root.searchParent(id)
      }
    }
  }

}
