package main.java.LeetCode.Tree;

import main.java.LeetCode.domain.TreeNode;
import main.java.LeetCode.util.BuiledTree;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * @ClassName a101MirrorTree
 * @Description
 * @Author WangRui
 * @Date 2020/8/7 10:25
 */
public class a101MirrorTree {
    public static void main(String[] args) {
        TreeNode root = BuiledTree.build(new TreeNode(-1), new int[]{1, 2, 2, 3, 4, 4, 3}, 0);
        BuiledTree.levelOrder(root);
        System.out.println("---建议用队列---");
        System.out.println(isMirror(root));
        System.out.println("---列表---");
        System.out.println(isSymmetric(root));

    }

    //数的对称，考虑用队列实现
    //1.思路 数的左右节点放在队列中，然后依次取出进行比较
    //2.     比较的情况 both null ,one of null ,value is not equal
    public static boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        //用队列保存节点
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        //将根节点的左右孩子放到队列中
        queue.add(root.left);
        queue.add(root.right);
        while (queue.size() > 0) {
            //从队列中取出两个节点，再比较这两个节点
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();
            //如果两个节点都为空就继续循环，两者有一个为空就返回false
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            //将左节点的左孩子， 右节点的右孩子放入队列
            queue.add(left.left);
            queue.add(right.right);
            //将左节点的右孩子，右节点的左孩子放入队列
            queue.add(left.right);
            queue.add(right.left);
            System.out.println(queue.size());
        }

        return true;
    }


    public static Boolean isMirror(TreeNode node) {

        if (node == null || node.left == null && node.right == null) {
            return true;
        }
        if (!check(node.left, node.right)) return false;
        //ArrayQueue类型的数不能添加null的值
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(node.left);
        deque.add(node.right);

        while (!deque.isEmpty()) {
            TreeNode l = deque.poll();
            TreeNode r = deque.poll();

            if (!check(l, r)) return false;

            if (!check(l.left, r.right)) return false;
            if (l.left != null) {
                deque.add(l.left);
                deque.add(r.right);
            }
            if (!check(l.right, r.left)) return false;
            if (l.right != null) {
                deque.add(l.right);
                deque.add(r.left);
            }

        }
        return true;
    }

    public static Boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return true;
    }
}
