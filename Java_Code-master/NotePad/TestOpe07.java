import java.util.Scanner;
public class TestOpe07{
	public static void main (String[] arges){
		Scanner input = new Scanner(System.in);
		System.out.println("��������������:");
		int num1 = input.nextInt(); 
		int num2 = input.nextInt();
		int num3 = input.nextInt();
		int sum  = 0;
		sum += num1;
		sum += num2;
		sum += num3;
		System.out.println("��:"+sum);
	}
}