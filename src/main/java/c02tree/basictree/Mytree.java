package main.java.c02tree.basictree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MytreeImpl
 * @Description
 * @Author WangRui
 * @Date 2020/8/5 20:14
 */
public class Mytree<E> implements ITree<E> {
    private int size = 0;
    private TreeNode root;

    public Mytree(TreeNode root) {
        this.root = root;
        size++;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public TreeNode<E> getRoot() {
        return root;
    }

    @Override
    public TreeNode<E> getParent(TreeNode<E> x) {
        return x.parent;
    }

    @Override
    public TreeNode<E> getFirstChild(TreeNode<E> x) {
        return x.children.get(0);
    }

    @Override
    public TreeNode<E> getBrother(TreeNode<E> x) {
        if (x.parent == null) {
            return null;
        }
        //通过父节点找到所有孩子
        List<TreeNode<E>> children = x.parent.children;
        //找到当前孩子的下标
        int i = children.indexOf(x);
        if (i == children.size() - 1) {
            return null;
        }
        //得到兄弟
        return children.get(i + 1);
    }

    @Override
    public int getHight(TreeNode<E> x) {
        if (x.children == null) {
            return 0;
        }
        int h = 0;
        for (int i = 0; i < x.children.size(); i++) {
            h = Math.max(h, getHight(x.children.get(i)));
        }
        //返回的是整棵树的高度
        return h + 1;
    }

    @Override
    public void insert(TreeNode<E> x, TreeNode<E> child) {
        if (x.children == null) {
            x.children = new ArrayList<>();

        }
        //父子节点相互关联
        x.children.add(child);
        child.parent = x;
        size++;

    }

    @Override
    public void delete(TreeNode<E> x, int i) {
        x.children.remove(i);
       size--;

    }

    @Override
    public List<TreeNode<E>> preOrder(TreeNode<E> x) {
        return null;
    }

    @Override
    public List<TreeNode<E>> infixOrder(TreeNode<E> x) {
        return null;
    }

    @Override
    public List<TreeNode<E>> postOrder(TreeNode<E> x) {
        return null;
    }
}
