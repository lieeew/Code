import java.util.*;
public class TestIf05{
	public static void main(String[] arges){
		Scanner sc = new Scanner (System.in);
		System.out.println("����������Ա�(��Ϊ1,ŮΪ2):");	
		int  sex = sc.nextInt();
		System.out.println("�������������:");
		int age = sc.nextInt();
		if(sex == 1){
			if (age > 5){
				System.out.println("�����");
			}else{
				System.out.println("�㻹̫С");	
			}
		} else if  (sex == 2){
			if (age > 7){
				System.out.println("�����");
			}else {
				System.out.println("�㻹̫С");	
			}
		}
	}
}