package main.scala.c01;

/**
 * ClassName TEST
 * Description
 *
 * @author WangRui
 * @date 2020/8/2
 * @time 20:47
 * @since JDK 1.8
 */
import java.util.Scanner;

public class TEST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] input = new int[6][6];
        for (int i=0; i<6; i++){
            for (int j=0; j<6; j++){
                    input[i][j] = 1;
            }
        }
        input[0][0] = 0;
        input[0][1] = 0;
        input[1][0] = 0;
        input[1][1] = 0;
        /*input[0][0] = 0;
        input[5][5] = 0;*/

        long sum = 1;

        for (int i=0; i<6; i++){
            for (int j=0; j<6; j++){
                if (input[i][j] == 0){
                    if (i == 0 && j == 0){
                        sum *= 6;
                    }else if (i == 0){
                        if (input[i][j-1] == 0){
                            sum *= 5;
                        }else {
                            sum *= 6;
                        }
                    }else if (j == 0){
                        if (input[i-1][j] == 0){
                            sum *= 5;
                        }else {
                            sum *= 6;
                        }
                    }else {
                        if (input[i][j-1] == 0 || input[i-1][j] == 0){
                            sum *= 5;
                        }else {
                            sum *= 6;
                        }

                    }
                }
            }
        }
        System.out.println(sum % 1000000009);
    }

}