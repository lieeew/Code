import java.util.*;  //* ��������
public class TestOpe12{
	public static void main (String[] arges){
		//ʵ�ֹ��ܣ��к�Ů��ѡ������ʲô��������һ�£��������ģ���������һ�£���Ů����
		Scanner input = new Scanner(System.in);
		System.out.println("��ѡ������ʲô��1.��� 2.�տ� 3.������ 4.����");
		System.out.println("���к�����:");
		int BoyChoice = input.nextInt();
		System.out.println("��Ů������:");
		int GrilChoice = input.nextInt(); 
		System.out.println(GrilChoice == BoyChoice?"���к�":"��Ů��" );
	}
}