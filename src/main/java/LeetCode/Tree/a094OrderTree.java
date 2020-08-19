package main.java.LeetCode.Tree;

import main.java.LeetCode.domain.TreeNode;
import main.java.LeetCode.util.BuiledTree;
import scala.util.Right;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName InfixOrderTree
 * @Description
 * @Author WangRui
 * @Date 2020/8/7 15:17
 */
public class a094OrderTree {
    public static void main(String[] args) {


        /*ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            //插入的数放在后面
            list.add(0, i);
        }
        for (int i = 0; i < list.size(); i++) {
            //4 3 2 1 0
            System.out.print(list.get(i) + "\t");
        }*/

        TreeNode tree = BuiledTree.tree();
        List<Integer> li = new ArrayList<>();
        System.out.println("---原始树层次遍历---");
        BuiledTree.levelOrder(tree);
        System.out.println("---前序遍历---");
        preorderTraversal(tree, li);
        for (Integer node : li) {
            System.out.print(node + "\t");
        }
        System.out.println();
        li.clear();

        System.out.println("---中序遍历---");
        infixorderTraversal(tree, li);
        for (Integer node : li) {
            System.out.print(node + "\t");
        }
        System.out.println();
        li.clear();

        System.out.println("---后序遍历---");
        List<Integer> integers = postorderTraversal(tree);
        for (Integer integer : integers) {
            System.out.print(integer + "\t");
        }
        System.out.println();
        postorderTraversal(tree, li);
        for (Integer node : li) {
            System.out.print(node + "\t");
        }
        System.out.println();
        li.clear();

    }

    public static void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);

        }
    }

    public static void infixorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            infixorderTraversal(root.left, list);
            list.add(root.val);
            infixorderTraversal(root.right, list);

        }
    }

    public static void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {

            if (root.left != null) {
                postorderTraversal(root.left, list);
            }
            if (root.right != null) {
                postorderTraversal(root.right, list);
            }
            list.add(root.val);
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //借助栈来实现
        Stack<TreeNode> s = new Stack<>();
        if (root == null) {
            return null;
        }
        s.push(root);

        while (!s.isEmpty()) {

            TreeNode node = s.pop();
            res.add(node.val);
            //右子树，先进后出
            if (node.right != null) {
                s.push(node.right);
            }

            if (node.left != null) {
                s.push(node.left);
            }

        }

        return res;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if (root == null) {
            return null;
        }
        s.push(root);

        while (!s.isEmpty()) {

            //前序 根左右
            //后续 左右根 -》list(0,根右左)
            TreeNode node = s.pop();
            res.add(0, node.val);
            if (node.left != null) {
                s.push(node.left);
            }

            if (node.right != null) {
                s.push(node.right);
            }

        }

        return res;
    }


    public List<Integer> infixorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

}
