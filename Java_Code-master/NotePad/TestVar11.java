import java.util.Scanner;
public class  TestVar11{
	public static void main(String [] arges){
		//键盘录入学生的信息：年龄，身高，姓名，性别：
        //键盘录入年龄：(接收int类型数据)
		Scanner sc = new Scanner (System.in);
		System.out.print("请输入你的年龄:");
		int age = sc.nextInt();
		System.out.print("请输入你的身高:");
		double height = sc.nextDouble();
		System.out.print("请输入你的名字:");
		String name =sc.next();
		System.out.print("请输入你的性别:");
		String sexstr = sc.next();
		char sex = sexstr.charAt(0);  //上面两句可以合为一句表示：char sex = sc.next().charAt(0);
		System.out.println("这个学生的个人信息:"+"年龄:"+age+",身高"+height+",姓名"+name",性别"+sex".");
		
	}
}