import java.util.Scanner;
public class  TestVar11{
	public static void main(String [] arges){
		//����¼��ѧ������Ϣ�����䣬��ߣ��������Ա�
        //����¼�����䣺(����int��������)
		Scanner sc = new Scanner (System.in);
		System.out.print("�������������:");
		int age = sc.nextInt();
		System.out.print("������������:");
		double height = sc.nextDouble();
		System.out.print("�������������:");
		String name =sc.next();
		System.out.print("����������Ա�:");
		String sexstr = sc.next();
		char sex = sexstr.charAt(0);  //����������Ժ�Ϊһ���ʾ��char sex = sc.next().charAt(0);
		System.out.println("���ѧ���ĸ�����Ϣ:"+"����:"+age+",���"+height+",����"+name",�Ա�"+sex".");
		
	}
}