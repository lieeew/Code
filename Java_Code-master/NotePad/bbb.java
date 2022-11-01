  /*/模拟用户登录
import java.util.*;
public class bbb{
	public static void main(String[] arges){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名:");
		String username = sc.nextLine();
		System.out.println("请输入密码:");
		String password = sc.nextLine();
		if(username == "qiu" && password == "123456"//这里一样见下面的解释 ){
			System.out.println("登陆成功!");
		}else if (username == "qiu" && password != "123456"  // 这里应该不对,不能用==,而是"admin".equals(username)&&"admin".equals(passwd))
		{ 
			System.out.println("密码错误.");
		}else{
			System.out.println("登录失败");
		}
		 
		
		
	}
}



import java.util.Scanner;
 
public class bbb {
 
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username=sc.nextLine();//将键盘录入的用户名存储到username中
		System.out.println("请输入密码：");
		String passwd=sc.nextLine();//将键盘录入的用户名存储到username中
		//如果字符串常量和变量比较，通常都是字符串常量调用方法，将变量当做参数传递，防止空指针异常
		if("admin".equals(username)&&"admin".equals(passwd)) {
			System.out.println("欢迎"+username+"登录");
			break;//当用户名/密码输入正确的时候，结束循环
		}else {
			if(i==2) {
				System.out.println("您的错误次数已到，请明天再来");
			}else {
				System.out.println("录入错误，您还有"+(2-i)+"次机会");
			}
			
		}
		
		
	}

————————————————
//版权声明：本文为CSDN博主「对抗路、余温」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/qq_24644517/article/details/82905751*/




import java.util.*;
public class bbb{
	public static void main(String[] arges){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入三个数字:");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		int sum = 0;
		sum += num1;
		sum += num2;
		sum += num3;
		System.out.println("和为:"+sum);
		if (sum >= 14){
			System.out.println("恭喜你获得一等奖");
		}else if (sum > 10){
			System.out.println("恭喜你获得二等奖");
		}else if (sum > 5){
			System.out.println("恭喜你获得三等奖");
			
		}else {
			System.out.println("再接再厉");
		}
	}
}