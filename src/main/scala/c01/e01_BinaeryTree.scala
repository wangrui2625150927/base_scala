package main.scala.c01

/**
  * ClassName e01_BinaeryTree 
  * Description  
  *
  * @author WangRui
  * @date 2020/8/1
  * @time 19:50
  * @since JDK 1.8
  */
object e01_BinaeryTree {
  def main(args: Array[String]): Unit = {
    val root = new Node(1, "宋江")
    val node1 = new Node(2, "吴用")
    val node2 = new Node(3, "卢俊义")
    val node3 = new Node(5, "关胜")
    val node4 = new Node(4, "林冲")
    root.left = node1
    root.right = node2
    node2.left = node3
    node2.right = node4
    val tree = new BinaeryTree
    tree.root = root
    println("---前序遍历---")
    tree.preOrder()
    println("---中序遍历---")
    tree.infixOrder()
    println("---后序遍历---")
    tree.postOrder()
   /* println("---前序搜索---")
    val treePreSe = tree.preOrderSearch(5)
    if (treePreSe != null) {
      println(treePreSe.no + "---" + treePreSe.name)
    } else {
      println("没找到")
    }
    val treePreSe1 = tree.infixOrderSearch(5)
    if (treePreSe1 != null) {
      println(treePreSe1.no + "---" + treePreSe1.name)
    } else {
      println("没找到")
    }
    val treePreSe2 = tree.postOrderSearch(5)
    if (treePreSe2 != null) {
      println(treePreSe2.no + "---" + treePreSe2.name)
    } else {
      println("没找到")
    }*/
    println("---删除后前序遍历---")
    tree.del(5)
    tree.preOrder()


  }

  //建立节点
  class Node(id: Int, str: String) {
    val no = id
    var name = str
    var left: Node = null
    var right: Node = null

    def preOrderSearch(id: Int): Node = {
      println("xxx~~~")
      if (this.no == id) {
        return this
      }
      var result: Node = null
      if (this.left != null) {
        result = this.left.preOrderSearch(id)
      }
      if (result != null) {
        return result
      }
      if (this.right != null) {
        result = this.right.preOrderSearch(id)
      }
      result
    }

    //前序遍历 根-》左-》右
    def preOrder(): Unit = {
      printf("节点信息 id=%d name=%s\n", no, name)
      if (this.left != null) {
        this.left.preOrder()
      }
      if (this.right != null) {
        this.right.preOrder()
      }
    }

    def infixOrderSearch(id: Int): Node = {

      var result: Node = null
      if (this.left != null) {
        result = this.left.infixOrderSearch(id)
      }
      if (result != null) {
        return result
      }
      println("yyy~~~")
      if (this.no == id) {
        return this
      }
      if (this.right != null) {
        result = this.right.infixOrderSearch(id)
      }
      result
    }

    //中序遍历 左-》根-》右
    def infixOrder(): Unit = {
      if (this.left != null) {
        this.left.infixOrder()
      }
      printf("节点信息 id=%d name=%s\n", no, name)
      if (this.right != null) {
        this.right.infixOrder()
      }
    }

    def postOrderSearch(id: Int): Node = {

      var result: Node = null
      if (this.left != null) {
        result = this.left.postOrderSearch(id)
      }
      if (result != null) {
        return result
      }
      if (this.right != null) {
        result = this.right.postOrderSearch(id)

      }
      if (result!=null){
        return result
      }
      println("zzz~~~")
      if (this.no == id) {
        return this
      }
      result
    }

    //后序遍历 左-》右-》根
    def postOrder(): Unit = {
      if (this.left != null) {
        this.left.postOrder()
      }
      if (this.right != null) {
        this.right.postOrder()
      }
      printf("节点信息 id=%d name=%s\n", no, name)
    }

    def del(id:Int): Unit ={
      if (this.left!=null &&this.left.no == id){
        this.left = null
        return
      }
      if (this.right!=null && this.right.no == id){
        this.right = null
        return
      }
     if (this.left!=null){
       this.left.del(id)
     }
      if (this.right!=null){
        this.right.del(id)
      }
    }
  }

  class BinaeryTree {
    var root: Node = null

    def preOrderSearch(id: Int): Node = {
      if (root != null) {
        root.preOrderSearch(id)
      } else {
        println("节点为空")
        null
      }
    }

    def preOrder(): Unit = {
      if (root != null) {
        root.preOrder()
      } else {
        println("节点为空")
      }
    }

    def infixOrderSearch(id: Int): Node = {
      if (root != null) {
        root.infixOrderSearch(id)
      } else {
        println("节点为空")
        null
      }
    }

    def infixOrder(): Unit = {
      if (root != null) {
        root.infixOrder()
      } else {
        println("节点为空")
      }
    }

    def postOrderSearch(id: Int): Node = {
      if (root != null) {
        root.postOrderSearch(id)
      } else {
        println("节点为空")
        null
      }
    }

    def postOrder(): Unit = {
      if (root != null) {
        root.postOrder()
      } else {
        println("节点为空")
      }
    }

    def del(id:Int): Unit ={
      if (root!=null){
        if (root.no == id){
          root = null
        }
        root.del(id)
      }
    }

  }

}
