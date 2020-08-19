package main.java.LeetCode.domain;

/**
 * @ClassName DemoCircleArrayQueue
 * @Description
 * @Author WangRui
 * @Date 2020/8/19 15:57
 */
public class DemoCircleArrayQueue {
    int size;
    int front;
    int rear;
    int[] q ;

    public DemoCircleArrayQueue(int size) {
        //环形队列 front和rear刚开始值0
        this.size = size;
        front = 0;
        rear  = 0;
        q = new int[size];
    }

    //判空
    public boolean isEmpty(){
       return front == rear;
    }

    //判空
    public boolean isFull(){
        //rear指针移动一圈后，和front指向同一位置
        return (rear+1)%size == front;
    }

    //添加元素
    public void add(int n){
        if (isFull()){
            System.out.println("队列满…………");
            return;
        }
        q[rear]=n;
        //环形队列，指针改变要取模
        rear = (rear+1) % size;
    }

    //获取元素
    public int get(){
        if (isEmpty()){
            System.out.println("队列空…………");
            return -1;

        }
        int value = q[front];
        //环形队列，指针改变要取模
        front = (front+1) % size;
        return value;
    }

    //获取元素
    public void list(){
        if (isEmpty()) {
            System.out.println("没有元素可以遍历");
            return;
        }
       for (int i = front;i<front+count();i++){
           System.out.printf("q[%d] = %d"+"\t",i%size,q[i%size]);
       }
        System.out.println();
    }

    //队列中元素个数
    public int count(){
        return (rear+size-front)%size;
    }
}
