import java.util.*;  //��ϰswitch
public class eee{
	public static void main(String[] arges){
		Scanner sc = new Scanner(System.in);
		System.out.println("���������ķ���:");
		int soccer = sc.nextInt();
		switch (soccer/10){
			case 9:
			case 8 :
			System.out.println("A");
			break;
			case 7:
			case 6:
			case 5:
			case 4:
			System.out.println("B");
			case 3:
			case 2:
			case 1:
			break;
			case 0:
			System.out.println("D");
			
		}
	}
}