/*import java.util.*;
public class TestIf03{
	public static void main(String[] arges){
		Scanner sc = new Scanner(System.in);
		System.out.println("��������������:");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		int sum = 0;
		sum += num1;
		sum += num2;
		sum += num3;
		// if-else ˫ѭ�����Ա��������������
		System.out.println(sum > 14? "�н���":"û�н�");
		if (sum > 14){
			System.out.println("�н���");
		}else {
			System.out.println("û�н�");
		}
	}
}*/



public class TestIf03{
	public static void main(String[] arges){
		int num1 = (int)(Math.random()*6) +1;  //�����
		int num2 = (int)(Math.random()*6) +1;
		int num3 = (int)(Math.random()*6) +1;
		int sum = 0;
		sum += num1;
		sum += num2;
		sum += num3;
		System.out.println("��Ϊ:"+sum);
		System.out.println(sum >= 14?"�н���":"û�н�");
		if (sum >= 14){
			System.out.println("�н���");
		}else{
			System.out.println("û�н�");
		}
		}
	}