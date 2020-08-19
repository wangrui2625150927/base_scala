package main.java.c02tree.basictree;

import java.util.List;

/**
 * @ClassName ITree
 * @Description
 * @Author WangRui
 * @Date 2020/8/5 20:06
 */
public interface ITree<E> {
    int getSize();
    TreeNode<E> getRoot();
    TreeNode<E> getParent(TreeNode<E> x);
    TreeNode<E> getFirstChild(TreeNode<E> x);
    TreeNode<E> getBrother(TreeNode<E> x);
    int getHight(TreeNode<E> x);
    void insert(TreeNode<E> x, TreeNode<E> chihld);
    void delete(TreeNode<E> x,int i);
    List<TreeNode<E>> preOrder(TreeNode<E> x);
    List<TreeNode<E>> infixOrder(TreeNode<E> x);
    List<TreeNode<E>> postOrder(TreeNode<E> x);
}
