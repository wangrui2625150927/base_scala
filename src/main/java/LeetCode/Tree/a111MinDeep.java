package main.java.LeetCode.Tree;

import main.java.LeetCode.domain.TreeNode;
import main.java.LeetCode.util.BuiledTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName a111MinDeep
 * @Description
 * @Author WangRui
 * @Date 2020/8/17 10:40
 * @Date 2020/8/17 10:40
 */
public class a111MinDeep {
    public static void main(String[] args) {
        List<TreeNode> list = new ArrayList<>();
        list.add(new TreeNode(3));
        list.add(new TreeNode(9));
        list.add(new TreeNode(20));
        list.add(null);
        list.add(null);
        list.add(new TreeNode(15));
        list.add(new TreeNode(7));
        TreeNode root = BuiledTree.build(new TreeNode(0), list, 0);
       // System.out.println(minDepth(root));

        List<TreeNode> li = new ArrayList<>();
        li.add(new TreeNode(1));
        li.add(null);
        li.add(new TreeNode(2));
        li.add(new TreeNode(3));
        TreeNode node = BuiledTree.build(new TreeNode(0), li, 0);
        BuiledTree.levelOrder(node);
    }
    public static int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left ==null && root.right==null){
            return 1;

        }
        int min_depth = Integer.MAX_VALUE;

        if(root.left!=null){
            System.out.println(minDepth(root.left));
            //左边往下找最小的
            min_depth = Math.min(minDepth(root.left), min_depth);

        }
        if(root.right!=null){
            System.out.println(minDepth(root.right));
            //右边往下找最小的
            min_depth =  Math.min(minDepth(root.right), min_depth);
        }

        return min_depth+1;
    }
}
