package main;

import java.util.Scanner;
import java.util.zip.DeflaterOutputStream;

/**
 * @ClassName test1
 * @Description
 * @Author WangRui
 * @Date 2020/8/9 19:09
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Double[] a = new Double[n];
        for (int i = 0; i < n; i++) {
            a[i] = Math.pow(-1,i)*sc.nextInt();

        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+"\t");
        }

        System.out.println(maxSubMax(a));
    }

    public static int maxSubMax(Double[] a) {
        double maxSum = 0, sum = 0;
        for (int i = 0; i < a.length; i++) {

            sum += a[i];

            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return (int)maxSum;
    }

}

/*
public class test1{
    public static void main(String[] args) {

                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = (int)Math.pow(-1,i)*sc.nextInt();

                }
                System.out.println(maxSubMax(a));
            }

            public static int maxSubMax(int[] a) {
                int maxSum = 0, sum = 0;
                int[] dp=new int[a.length];
                dp[0]=a[0];
                for (int i = 1; i < a.length; i++) {
                    dp[i]=Math.max(dp[i-1]+a[i],a[i])   ;
                }

                for (int i = 0; i <a.length; i++){
                    if(dp[i]>maxSum){
                        maxSum=dp[i];
                    }
                }
                return maxSum;
            }


        }*/
