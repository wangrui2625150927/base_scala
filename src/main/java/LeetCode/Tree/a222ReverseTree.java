package main.java.LeetCode.Tree;

import main.java.LeetCode.domain.TreeNode;
import main.java.LeetCode.util.BuiledTree;
import scala.xml.Node;

import java.security.Principal;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName a222ReverseTree
 * @Description
 * @Author WangRui
 * @Date 2020/8/11 13:33
 */
public class a222ReverseTree {
    public static void main(String[] args) {
        TreeNode tree = BuiledTree.tree();
        BuiledTree.levelOrder(tree);
        System.out.println("---二叉树翻转后---");
        TreeNode node = invertTree(tree);
        BuiledTree.levelOrder(node);
    }

    public static TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> deq = new LinkedList<>();
        if (root != null) {
            deq.add(root);
        }
        while (!deq.isEmpty()) {
            TreeNode node = deq.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                deq.add(node.left);
            }
            if (node.right != null) {
                deq.add(node.right);
            }

        }
        return root;
    }

}
