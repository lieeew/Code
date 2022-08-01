import java.util.Scanner;
public class TestOpe02{
	public static void main(String [] arges){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个四位数:");
		int num = input.nextInt();  //输入一个四位数
		int num1 = num % 10;        //个位上的数
		int num2 = num % 100 / 10;  //十位数的数
		int num3 = num % 1000 / 100;// 百位上的数
		int num4 = num / 1000;      //千位上的数
		System.out.println("个位上的数:"+num1);
		System.out.println("十位上的数:"+num2);
		System.out.println("百位上的数:"+num3);
		System.out.println("千位上的数:"+num4);	
	}
}