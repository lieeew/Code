import java.util.*;
public class TestIf05{
	public static void main(String[] arges){
		Scanner sc = new Scanner (System.in);
		System.out.println("请输入你的性别(男为1,女为2):");	
		int  sex = sc.nextInt();
		System.out.println("请输入你的年龄:");
		int age = sc.nextInt();
		if(sex == 1){
			if (age > 5){
				System.out.println("你可以");
			}else{
				System.out.println("你还太小");	
			}
		} else if  (sex == 2){
			if (age > 7){
				System.out.println("你可以");
			}else {
				System.out.println("你还太小");	
			}
		}
	}
}