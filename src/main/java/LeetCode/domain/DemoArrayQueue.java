package main.java.LeetCode.domain;

/**
 * @ClassName DemoArrayQueue
 * @Description
 * @Author WangRui
 * @Date 2020/8/19 15:29
 */
public class DemoArrayQueue {
    //使用数组来模拟实现队列
    //front = -1 头指针
    //rear = -1 尾指针
    int size;
    int front;
    int rear;
    int[] q;

    public DemoArrayQueue(int size) {
        this.size = size;
        front = -1;
        rear = -1;
        q = new int[size];
    }

    //判断队空 -- front和rear相等
    private boolean isEmpty() {
        return front == rear;
    }

    //判断队满 -- rear = size -1
    private boolean isFull() {
        return rear == size - 1;
    }

    //添加元素
    public void add(int n) {
        if (isFull()) {
            System.out.println("队列满…………");
            return;
        }
        rear += 1;
        q[rear] = n;
    }

    //取出元素
    public int get() {
        if (isEmpty()) {
            System.out.println("队列空…………");
            return -1;
        }
        front += 1;
        return q[front];
    }

    //遍历队列
    public void list() {
        if (isEmpty()) {
            System.out.println("没有元素可以遍历");
            return;
        }
        //从front的下一个指针位置开始遍历，到rear指向的位置结束
        for (int i = front + 1; i <= rear; i++) {
            System.out.print(q[i] + "\t");
        }
        System.out.println();
    }

}
