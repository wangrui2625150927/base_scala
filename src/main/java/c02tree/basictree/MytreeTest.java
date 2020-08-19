package main.java.c02tree.basictree;

import java.security.Principal;

/**
 * @ClassName MytreeTest
 * @Description
 * @Author WangRui
 * @Date 2020/8/6 10:48
 */
public class MytreeTest {


    public static void main(String[] args) {

    
        Mytree<String> mytree =new Mytree<>(new TreeNode("a"));
        TreeNode<String> root = mytree.getRoot();
        TreeNode<String> b = new TreeNode<>("b");
        TreeNode<String> c = new TreeNode<>("c");
        TreeNode<String> d = new TreeNode<>("d");
        TreeNode<String> e = new TreeNode<>("e");
        TreeNode<String> f = new TreeNode<>("f");
        TreeNode<String> g = new TreeNode<>("g");
        TreeNode<String> h = new TreeNode<>("h");
        TreeNode<String> i = new TreeNode<>("i");
        TreeNode<String> j = new TreeNode<>("j");

        mytree.insert(root,b);
        mytree.insert(root,c);
        mytree.insert(root,d);
        mytree.insert(b,e);
        mytree.insert(b,f);
        mytree.insert(c,g);
        mytree.insert(d,h);
        mytree.insert(e,i);
        mytree.insert(i,j);
        System.out.println(mytree.getHight(b));
        System.out.println("获取兄弟节点");
        System.out.println(mytree.getBrother(b).key);
        System.out.println("获取孩子节点");
        System.out.println(mytree.getFirstChild(b).key);
        System.out.println("获取----");
    }
}
