import java.util.Scanner;
public class TestOpe02{
	public static void main(String [] arges){
		Scanner input = new Scanner(System.in);
		System.out.println("������һ����λ��:");
		int num = input.nextInt();  //����һ����λ��
		int num1 = num % 10;        //��λ�ϵ���
		int num2 = num % 100 / 10;  //ʮλ������
		int num3 = num % 1000 / 100;// ��λ�ϵ���
		int num4 = num / 1000;      //ǧλ�ϵ���
		System.out.println("��λ�ϵ���:"+num1);
		System.out.println("ʮλ�ϵ���:"+num2);
		System.out.println("��λ�ϵ���:"+num3);
		System.out.println("ǧλ�ϵ���:"+num4);	
	}
}