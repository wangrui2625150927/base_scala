package main.scala.c01

/**
  * ClassName e03_orderBinaeryTree 
  * Description  
  *
  * @author WangRui
  * @date 2020/8/2
  * @time 17:06
  * @since JDK 1.8
  */
object e03_orderBinaeryTree {
  def main(args: Array[String]): Unit = {
    var array = Array(7, 3, 10, 12, 5, 1, 9, 2)
    val tree = new BinaeryTree
    for (elem <- array) {
      tree.add(new Node(elem))
    }
    tree.infixOrder()
    println(tree.search(5).value)
    println(tree.searchParent(5).value)
    tree.del(3)
    tree.infixOrder()
  }

  class Node(nu: Int) {
    var value = nu
    var left: Node = null
    var right: Node = null

    def add(node: Node): Unit = {
      if (node == null) {
        return
      }
      if (node.value < this.value) {
        if (this.left == null) {
          this.left = node
        } else {
          this.left.add(node)
        }
      } else {
        if (this.right == null) {
          this.right = node
        } else {
          this.right.add(node)
        }
      }
    }

    def infixOrder(): Unit = {
      if (this.left != null) {
        this.left.infixOrder()
      }
      print(this.value + "\t")
      if (this.right != null) {
        this.right.infixOrder()
      }
    }


    def search(no: Int): Node = {
      if (this.value == no) {
        return this
      }
      if (no < this.value) {
        if (this.left != null) {
          this.left.search(no)
        } else {
          null
        }
      }
      else {
        if (this.right != null) {
          this.right.search(no)
        } else {
          null
        }
      }
    }

    def searchParent(no: Int): Node = {
      if (this.left != null && this.left.value == no || this.right != null && this.right.value == no) {
        return this
      }
      if (this.left != null && this.value > no) {
        this.left.searchParent(no)
      } else if (this.right != null && this.value < no) {
        this.right.searchParent(no)
      } else {
        null
      }

    }

    import scala.util.control.Breaks._

    //找到右子树的最小值，并删除更该节点的值
    def findRightMinValue(node: Node): Int = {
      var target = node
      breakable(
        while (true) {
          if (target.left == null) {
            break()
          }
          target = target.left
        }
      )
      del(target.value)
      target.value

    }

    def del(no: Int): Unit = {
      val node = search(no)
      if (node == null) {
        return
      }
      val parentNode = searchParent(no)

      //满足下面的条件，说明是叶子节点
      if (node.left == null && node.right == null) {
        if (parentNode.left != null && parentNode.left.value == no) {
          parentNode.left = null
        } else if (parentNode.right != null && parentNode.right.value == no) {
          parentNode.right = null
        }
        //删除的节点，该节点有两个节点
      } else if (node.left != null && node.right != null) {
        val minValue = findRightMinValue(node.right)

        node.value = minValue
      }else{
        //删除的节点只有一个，判断是在左边还是右边
        if (node.left!=null){
          //父节点指向删除节点的左子树
          if (parentNode.left.value == node.value){
            parentNode.left = node.left
          }else{
            parentNode.right = node.left
          }
        }else if(node.right!=null){
          //父节点指向删除节点的右子树
          if (parentNode.left.value == node.value){
            parentNode.left = node.right
          }else{
            parentNode.right = node.right
          }
        }
      }
    }


  }

  class BinaeryTree {
    var root: Node = null

    def infixOrder(): Unit = {
      if (root != null) {
        root.infixOrder()
      }
    }

    def add(node: Node): Unit = {
      if (root != null) {
        root.add(node)
      } else {
        root = node
      }
    }

    def search(id: Int): Node = {
      if (root != null) {
        return root.search(id)
      }
      null
    }

    def searchParent(id: Int): Node = {
      if (root != null) {
        return root.searchParent(id)
      }
      null
    }

    def del(no: Int): Unit = {
      if (root != null) {
        root.del(no)
      }

    }
  }


}
