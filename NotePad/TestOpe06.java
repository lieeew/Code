import java.util.Scanner;
public class TestOpe06{
	public static void main(String[] arges){
	Scanner input = new Scanner(System.in);
	System.out.println("��������������:");
	int num1 = input.nextInt();
	int num2 = input.nextInt();
	System.out.println("�任ǰ:"+num1+"\t"+num2);
	int t = num1;   // ��һ�������洢num1
	num1 = num2;
	num2 = t;
	System.out.println("�任��:"+num1+"\t"+num2);
	
	}
}