package main.java.LeetCode.array;

/**
 * @ClassName a485CountArray
 * @Description
 * @Author WangRui
 * @Date 2020/8/8 9:59
 */
public class a485CountArray {
    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 0, 1, 1, 1};
        int count = 0;
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i]==1){
                count++;
            }
            if (a[i] == 0||i== a.length-1) {
                if (count>temp){
                    temp = count;
                }
                count = 0;
                continue;
            }



        }
        System.out.println("个数是"+temp);
    }
}
