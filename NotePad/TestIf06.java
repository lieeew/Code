import java.util.*;
public class TestIf06{
	public static void main(String[] arges){
		Scanner sc = new Scanner(System.in);
		System.out.println("��������������:");
		int age = sc.nextInt();
		if (age > 7){
			System.out.println("yes");
		}else if (age > 5){
			System.out.println("�����������Ա�:");
			String sex = sc.next();
			char s = sex.charAt(0);  // �Ա�char����
			if(s == '��'){
				System.out.println("ok");
			}else if(s == 'Ů'){
				System.out.println("no");
			}
			
		}else {
			System.out.println("�㻹̫С");
		}
		
	}
}