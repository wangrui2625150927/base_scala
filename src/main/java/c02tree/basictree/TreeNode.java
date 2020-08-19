package main.java.c02tree.basictree;

import java.util.List;

/**
 * @ClassName TreeNode
 * @Description
 * @Author WangRui
 * @Date 2020/8/5 19:52
 */
public class TreeNode<E> {
    public E key;
    public TreeNode<E> parent;
    public List<TreeNode<E>> children;

    public TreeNode(E key, TreeNode<E> parent) {
        this.key = key;
        this.parent = parent;
    }

    public TreeNode(E key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "key=" + key +
                '}';
    }
}
