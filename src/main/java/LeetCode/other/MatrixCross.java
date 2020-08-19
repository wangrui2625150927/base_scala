package main.java.LeetCode.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatrixCross {

    public static void main(String[] args) {
        boolean flag = true;

        int[][] a = new int[][]{
                {1, 0,0},
                {0, 10, 10},
                {0, 10, 10}
                //{1, 2,3},
                //{4, 5, 6},
                //{7, 8, 9}
        };

        int row = a.length;
        int col = a[0].length;

        while (flag) {

            int allSum = 0;
            List<Node> list = new ArrayList<>();
            //m代表行数
            int m = 0;
            //n代表列数
            int n = 0;
            System.out.println("新的遍历");
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print(a[i][j] + "\t");
                }
                System.out.println();
            }
            while (m < col) {
                int sum = 0;
                for (int j = 0; j < col; j++) {
                    //每一行相加
                    sum += a[m][j];
                }
                for (int c = 0; c < col; c++) {
                    int sumcol = 0;
                    for (int i = 0; i < row; i++) {
                        //每一列相加
                        sumcol += a[i][n];
                    }
                    list.add(new Node(m + 1, n + 1, sum + sumcol - a[m][n]));
                    n++;
                }
                n = 0;
                m++;
            }
            //for (Node node : list) {
            //    System.out.println(node.i + "," + node.j + " " + node.sum);
            //}
            System.out.println("行列值最大的一行下标");
            Node minNode = minIJ(list);
            System.out.println(minNode.i+" "+minNode.j);
            //i行置为0
            for (int j = 0; j < col; j++) {
                a[minNode.i - 1][j] = 0;
            }
            //j列置为0
            for (int i = 0; i < row; i++) {
                a[i][minNode.j - 1] = 0;
            }
            //斩掉的是下 。右
            if (minNode.i==row&& minNode.j==col){
                row --;
                col--;
            }
            //斩掉的是上 。右
            if (minNode.i-1==0&& minNode.j==col){
                for(int i=0;i<row-1;i++){
                    for (int j=0;j<col;j++){
                        a[i][j]=a[i+1][j];
                    }
                }
                row--;
                col--;
            }
            //斩掉的是下。左
            if (minNode.i-1==0&& minNode.j==col){
                for(int i=0;i<row;i++){
                    for (int j=0;j<col-1;j++){
                        a[i][j]=a[i][j+1];
                    }
                }
                row--;
                col--;
            }
            //斩掉的是上。左
            if (minNode.i-1==0&& minNode.j-1==0){
                for(int i=0;i<row-1;i++){
                    for (int j=0;j<col-1;j++){
                        a[i][j]=a[i+1][j+1];
                    }
                }
                row--;
                col--;
            }
            if (minNode.i-1>0&& minNode.i<row&&minNode.j-1>0&&minNode.j<col){
                for(int i=minNode.i-1;i<row-1;i++){
                    for (int j=minNode.j-1;j<col-1;j++){
                        a[i][j]=a[i+1][j+1];
                    }
                }
                row--;
                col--;
            }
            System.out.println("---十字斩后结果---");
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    allSum += a[i][j];
                    System.out.print(a[i][j] + "\t");
                }
                System.out.println();
            }
            if (a[0][0]==0){
                System.out.println(1+" "+1);
            }
            if (allSum == 0  ) {
                flag = false;

            }
        }

    }

    //寻找行列之和最大值
    public static int maxVal(List<Node> list) {
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).sum > max)
                max = list.get(i).sum;
        }
        return max;
    }

    //寻找最大值中i，j小的那一个
    public static Node minIJ(List<Node> list) {
        int maxVal = maxVal(list);
        List<Node> li = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).sum == maxVal) {
                li.add(list.get(i));
            }
        }
        int minI = li.get(0).i + li.get(0).j;
        Node minNode = li.get(0);
        for (int i = 1; i < li.size(); i++) {

            if (minI > li.get(i).i + li.get(i).j) {
                minNode = li.get(i);
            }
        }
        return minNode;
    }

  static   class Node {
        int i;
        int j;
        int sum;

        public Node(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }
}


