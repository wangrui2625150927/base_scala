package main.java.LeetCode.util;

import main.java.LeetCode.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName BuiledTree
 * @Description
 * @Author WangRui
 * @Date 2020/8/7 10:28
 */
public class BuiledTree {
    /*
     * @Description 考虑退出的边界，以及递归的执行顺序
     * @Author WangRui
     * @Date 2020/8/7 10:40
     * @Param [node, list, index]
     * @return main.java.LeetCode.util.TreeNode
     */
    //利用数组建立普通二叉树
    public static TreeNode build(TreeNode node, List<TreeNode> list, int index){
        //超出边界，则返回上一层节点
        if (index*2+2>list.size()){
            return node;
        }
        if (index == 0){
            //根节点赋值
            node = list.get(0);
        }
        node.left = list.get(index*2+1);
        node.right = list.get(index*2 + 2);
        //建立左子树
        build(node.left,list,index*2+1);
        //建立右子树
        build(node.right,list,index*2+2);
        return node;
    }

    public static TreeNode build(TreeNode node, int [] a, int index){
        //超出边界，则返回上一层节点
        if (index*2+2>a.length){
            return node;
        }
        if (index == 0){
            //根节点赋值
            node = new TreeNode(a[0]);
        }
        node.left = new TreeNode(a[index*2 + 1]);
        node.right = new TreeNode(a[index*2 + 2]);
        //建立左子树
        build(node.left,a,index*2+1);
        //建立右子树
        build(node.right,a,index*2+2);
        return node;
    }

    //层序遍历，用队列实现每一层的输出，一个节点输出后，把他的子节点加入到队列中
    public static void levelOrder(TreeNode root){
        if (root == null){
            return;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
        int size = deque.size();
        for (int i =0 ;i<size;i++){
            TreeNode node = deque.poll();
            System.out.print(node.val+"\t");
            if (node.left!=null){
                deque.add(node.left);
            }
            if (node.right!=null){
                deque.add(node.right);
            }
        }
            System.out.println();
        }
    }

    public static TreeNode tree(){
        ArrayList<TreeNode> list = new ArrayList<>();
        //[3,9,20,null,null,15,7],
        list.add(new TreeNode(3));
        list.add(new TreeNode(9));
        list.add(new TreeNode(20));
        list.add(null);
        list.add(null);
        list.add(new TreeNode(15));
        list.add(new TreeNode(7));
        TreeNode root = BuiledTree.build(null, list, 0);
        return root;
    }

    public static void main(String[] args) {
        ArrayList<TreeNode> list = new ArrayList<>();
        //[3,9,20,null,null,15,7],
        list.add(new TreeNode(3));
        list.add(new TreeNode(9));
        list.add(new TreeNode(20));
        list.add(null);
        list.add(null);
        list.add(new TreeNode(15));
        list.add(new TreeNode(7));
        TreeNode root = BuiledTree.build(null, list, 0);
        BuiledTree.levelOrder(root);
    }
}

