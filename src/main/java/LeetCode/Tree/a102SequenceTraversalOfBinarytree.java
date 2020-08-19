package main.java.LeetCode.Tree;

import main.java.LeetCode.domain.TreeNode;
import main.java.LeetCode.util.BuiledTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName a_102SequenceTraversalOfBinarytree
 * @Description
 * @Author WangRui
 * @Date 2020/8/6 14:50
 */
public class a102SequenceTraversalOfBinarytree {

    public static void main(String[] args) {
        TreeNode root = BuiledTree.tree();
        List<List<Integer>> lists = levelOrder(root);
        System.out.println("-------------------------");
        for (List<Integer> integers : lists) {
            for (Integer integer : integers) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        //每一个List<Integer>中存放的是一层的元素
        List<List<Integer>> res = new ArrayList<>();

        //注意：ArrayDeque中不能添加null
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);//根节点加在队列中
        }
        while (!queue.isEmpty()) {
            //每一次向队列里面加的个数
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                //出去一个值。把当前节点的左右节点的值加入进来
                TreeNode node = queue.poll();
                level.add(node.val); //队列中出去的值放在列表中
                if (node.left != null) {
                    queue.add(node.left); //加在队列中，用于值的输出
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //一层一层的加入列表中
            res.add(level);
        }
        return res;
    }

}

