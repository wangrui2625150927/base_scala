package main.java.LeetCode.Tree;

import jdk.nashorn.internal.ir.IfNode;
import main.java.LeetCode.domain.TreeNode;
import main.java.LeetCode.util.BuiledTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName a100SameTree
 * @Description
 * @Author WangRui
 * @Date 2020/8/6 19:58
 */
public class a100SameTree {


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

        TreeNode root = BuiledTree.tree();
        TreeNode root0 = BuiledTree.build(list.get(0), list, 0);
        System.out.println(isSameTree(root, root0));
    }

    public static boolean check(TreeNode p, TreeNode q) {
        // 3种情况进行考虑
        // p and q are null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return true;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (!check(p, q)) return false;

        //队列的使用
        Queue<TreeNode> deqP = new ArrayDeque<>();
        Queue<TreeNode> deqQ = new ArrayDeque<>();
        deqP.add(p);
        deqQ.add(q);

        while (!deqP.isEmpty()) {
            p = deqP.poll();
            q = deqQ.poll();


            if (!check(p, q)) return false;

            // in Java nulls are not allowed in Deque
            if (!check(p.left, q.left)) return false;
            if (p.left != null) {
                deqP.add(p.left);
                deqQ.add(q.left);
            }
            if (!check(p.right, q.right)) return false;
            if (p.right != null) {
                deqP.add(p.right);
                deqQ.add(q.right);
            }

        }

        return true;
    }


}
