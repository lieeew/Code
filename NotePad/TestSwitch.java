import java.util.*;
public class TestSwitch{
	public static void main(String[] arges){
		Scanner sc = new Scanner(System.in);
		System.out.println("������ѧ���ķ���:");
		int score = sc.nextInt();
		switch(score/10){
			case 10 : 
			System.out.println("A��");
			break;
			case 9:
			System.out.println("A��");
			break;
			case 8:
			System.out.println("B��");
			break;
			case 7:
			System.out.println("C��");
			break;
			case 6:
			System.out.println("D��");
			break;
			case 5:
			case 4:
			case 3:
			case 2:
			case 1:
			case 0: System.out.println("E��");
			default : System.out.println("��������ȷ�ĳɼ�!");
			
			
		}
	 	
	}
}