import java.util.*;
public class TestSwitch{
	public static void main(String[] arges){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入学生的分数:");
		int score = sc.nextInt();
		switch(score/10){
			case 10 : 
			System.out.println("A级");
			break;
			case 9:
			System.out.println("A级");
			break;
			case 8:
			System.out.println("B级");
			break;
			case 7:
			System.out.println("C级");
			break;
			case 6:
			System.out.println("D级");
			break;
			case 5:
			case 4:
			case 3:
			case 2:
			case 1:
			case 0: System.out.println("E级");
			default : System.out.println("请输入正确的成绩!");
			
			
		}
	 	
	}
}