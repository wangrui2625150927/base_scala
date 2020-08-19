package main.java.LeetCode.util;

import main.java.LeetCode.domain.DemoArrayQueue;
import main.java.LeetCode.domain.DemoCircleArrayQueue;

import java.util.Scanner;

/**
 * @ClassName BuiledArrayQueue
 * @Description
 * @Author WangRui
 * @Date 2020/8/19 9:47
 */
public class BuiledArrayQueue {
    public static void main(String[] args) {
        //DemoArrayQueue queue = new DemoArrayQueue(5);
        DemoCircleArrayQueue queue = new DemoCircleArrayQueue(4);
        while (true) {
            System.out.println("add----");
            System.out.println("get----");
            System.out.println("list----");
            System.out.println("break");
            System.out.println("请选择---");
            Scanner sc = new Scanner(System.in);
            String key = sc.nextLine();
            switch (key) {
                case "add":
                    System.out.println("请添加元素：");
                    int n = sc.nextInt();
                    queue.add(n);
                    break;

                case "get":
                    System.out.println(queue.get());
                    break;

                case "list":
                    queue.list();
                    break;

                case "break":
                    System.exit(0);
                    break;
                default:
                    System.out.println("请重新输入----");
                    break;
            }


        }
    }
}


