  /*/ģ���û���¼
import java.util.*;
public class bbb{
	public static void main(String[] arges){
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û���:");
		String username = sc.nextLine();
		System.out.println("����������:");
		String password = sc.nextLine();
		if(username == "qiu" && password == "123456"//����һ��������Ľ��� ){
			System.out.println("��½�ɹ�!");
		}else if (username == "qiu" && password != "123456"  // ����Ӧ�ò���,������==,����"admin".equals(username)&&"admin".equals(passwd))
		{ 
			System.out.println("�������.");
		}else{
			System.out.println("��¼ʧ��");
		}
		 
		
		
	}
}



import java.util.Scanner;
 
public class bbb {
 
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("�������û�����");
		String username=sc.nextLine();//������¼����û����洢��username��
		System.out.println("���������룺");
		String passwd=sc.nextLine();//������¼����û����洢��username��
		//����ַ��������ͱ����Ƚϣ�ͨ�������ַ����������÷����������������������ݣ���ֹ��ָ���쳣
		if("admin".equals(username)&&"admin".equals(passwd)) {
			System.out.println("��ӭ"+username+"��¼");
			break;//���û���/����������ȷ��ʱ�򣬽���ѭ��
		}else {
			if(i==2) {
				System.out.println("���Ĵ�������ѵ�������������");
			}else {
				System.out.println("¼�����������"+(2-i)+"�λ���");
			}
			
		}
		
		
	}

��������������������������������
//��Ȩ����������ΪCSDN�������Կ�·�����¡���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
//ԭ�����ӣ�https://blog.csdn.net/qq_24644517/article/details/82905751*/




import java.util.*;
public class bbb{
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
		System.out.println("��Ϊ:"+sum);
		if (sum >= 14){
			System.out.println("��ϲ����һ�Ƚ�");
		}else if (sum > 10){
			System.out.println("��ϲ���ö��Ƚ�");
		}else if (sum > 5){
			System.out.println("��ϲ�������Ƚ�");
			
		}else {
			System.out.println("�ٽ�����");
		}
	}
}