package main.java.c02tree.binaerytree;


/**
 * @ClassName TreeNode
 * @Description
 * @Author WangRui
 * @Date 2020/8/5 11:02
 */
public class BinaeryTree {

    public static void main(String[] args) {
        BinaeryTree tree = new BinaeryTree();
        int[] a = new int[]{7, 4, 5, 2, 1, 9, 8, 12};
        for (int i = 0; i < a.length; i++) {
            tree.add(new TreeNode(a[i]));
        }
        tree.list();
        System.out.println(tree.search(5).toString());
        //  System.out.println(tree.searchParent(7).toString());
        tree.del(10);
        tree.list();
    }
    TreeNode root = null;

    public void add(TreeNode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void list() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("没有元素可以遍历");
        }
    }

    public TreeNode search(int id) {
        if (root != null) {
            if (root.getId() == id) {
                return root;
            } else {
                return root.search(id);
            }
        }
        return null;
    }

    public TreeNode searchParent(int id) {
        if (root != null) {
            return root.searchParent(id);
        }
        return null;
    }
    public void del(int id){
        if (root!=null){
            root.del(id);
        }
    }



}

class TreeNode {
    private int id;
    private TreeNode left;
    private TreeNode right;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                '}';
    }

    public void add(TreeNode node) {
        if (node == null) {
            return;
        }
        if (this.id > node.id) {
            if (this.left != null) {
                this.left.add(node);
            } else {
                this.left = node;
            }
        } else {
            if (this.right != null) {

                this.right.add(node);
            } else {
                this.right = node;
            }
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.print(this.id + "\t");
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public TreeNode search(int id) {
        if (this.id == id) {
            return this;
        }
        if (this.id > id) {
            //id小 从左边找
            if (this.left != null) {
                return this.left.search(id);
            } else {
                return null;
            }
        } else {
            //id大 从右边找
            if (this.right != null) {
                return this.right.search(id);
            } else {
                return null;
            }
        }

    }

    public TreeNode searchParent(int id) {
        if (this.left != null && this.left.id == id || this.right != null && this.right.id == id) {
            return this;
        }
        if (this.left != null && this.id > id) {
            return this.left.searchParent(id);
        } else if (this.right != null && this.id <= id) {
            return this.right.searchParent(id);
        } else {
            return null;
        }
    }

    public int findMinValue(TreeNode node){
        while (node.left!=null){
            node = node.left;
        }

        int value = node.id;
        del(value);
       return value;
    }
    public int findMaxValue(TreeNode node){
        while (node.right!=null){
            node = node.right;
        }
        int value = node.id;
        del(node.id);
        return value;
    }

    //删除节点时，要考虑3种情况
    //1.删除的是叶子节点，则直接置空
    //2.删除的是非叶子节点 只有一个子节点
    //3.---------------  有两个子节点
    public void del(int id) {
        TreeNode node = search(id);
        if (node == null) {
            return;
        }
        TreeNode parent = searchParent(id);
        if (node.left == null && node.right == null) {
            //删除的节点是在父节点的左边还是右边
            if (parent.left != null&&parent.left.id == id) {
                parent.left = null;
            }
            if (parent.right != null &&parent.right.id == id) {
                parent.right = null;
            }
        }else if (node.left!=null && node.right!=null){
               TreeNode temp = parent;
               int a =id;
               TreeNode cur = null;
               while (temp!=null){
                    temp = searchParent(a);
                    if (temp!=null){
                        a = temp.id;
                        cur = temp;
                    }
               }
            if (cur.id>id){
                int maxValue = findMaxValue(node.left);
                node.id = maxValue;
            }else{
                int minValue = findMinValue(node.right);
                System.out.println("minvalue = " +minValue);
                node.id = minValue;
            }
        }else{
            if (node.left!=null){
                if (parent.left!=null&&parent.left.id==id){
                    parent.left = node.left;
                }else{
                    parent.right = node.left;
                }
            }else{
                if (parent.left!=null&&parent.left.id==id){
                    parent.left = node.right;
                }else{
                    parent.right = node.right;
                }
            }
        }

    }
}
