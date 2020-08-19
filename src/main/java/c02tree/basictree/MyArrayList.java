package main.java.c02tree.basictree;

import java.util.Arrays;

/**
 * ClassName MyArrayList
 * Description
 *
 * @author WangRui
 * @date 2020/8/5
 * @time 9:25
 * @since JDK 1.8
 */
public class MyArrayList implements MyArrayListI<Object> {
    private Object[] array;
    private int size = 0;//数组现在的大小
    private int capacity = 10;//数组默认的容量

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    public MyArrayList() {
        array = new Object[capacity];
    }

    @Override
    public void add(Object object) {
        //容量超出则进行扩容
        if (size == capacity) {
            capacity *= 2;
            Object[] newArr = new Object[capacity];
            System.arraycopy(array, 0, newArr, 0, size);
            array = newArr;

        }
        array[size++] = object;
    }

    @Override
    public void del(Object object) {
        for (int i = 0;i<size;i++){
            if (array[i]==object){
                array[i]=0;
                Arrays.sort(array);
            }
        }

    }

    @Override
    public void update(int id, Object object) {
        Object search = search(id);
        if (search!=null){
            array[id]=object;
        }
    }

    @Override
    public Object search(int id) {
        Object o = array[id];
        if (o!=null){
            return o;
        }
        return null;
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            if ((int)array[i]!=0){
                System.out.print(array[i] + "\t");
            }

        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        for (int i = 0; i < 12; i++) {
            list.add(i);
        }
        System.out.println(list.capacity);
        list.list();
    }
}
