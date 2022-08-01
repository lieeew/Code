import java.util.*;
public class TestIf06{
	public static void main(String[] arges){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入您的年龄:");
		int age = sc.nextInt();
		if (age > 7){
			System.out.println("yes");
		}else if (age > 5){
			System.out.println("请输入您的性别:");
			String sex = sc.next();
			char s = sex.charAt(0);  // 性别char类型
			if(s == '男'){
				System.out.println("ok");
			}else if(s == '女'){
				System.out.println("no");
			}
			
		}else {
			System.out.println("你还太小");
		}
		
	}
}