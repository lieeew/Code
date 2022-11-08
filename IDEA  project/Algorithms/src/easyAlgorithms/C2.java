package easyAlgorithms;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/8 - 11 - 08
 * @Description: easyAlgorithms
 */
import java.util.Scanner;
public class C2{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("请输入一个数：");
        int number = sc.nextInt();
        if(number % 2 == 0){
            System.out.println( number + "是偶数");
        }else{
            System.out.println( number + "是奇数");
        }
    }
}
