import java.util.*;
public class TestIf04{
	public static void main(String[] arges){
		Scanner sc = new Scanner(System.in);
		System.out.println("���������Ļ�Ա����:");
	if(  sc.hasNextInt() == true ){  // ������!!!
		 int soccer = sc.nextInt() ; // ������!!!
		 double  discount = 0.1;  //����з�Χ,д��ĳһ��if����ᱨ��
		if (soccer > 8000){
			discount = 0.6;
		}else if (soccer >= 4000){
			discount = 0.7;
		}else if (soccer >= 2000 ){
			discount = 0.8;
		}else {
			discount = 0.9;
		}System.out.println("�����ۿ�Ϊ:"+discount);
		
	}else {
		System.out.println("����������");
	}
	}
}
	
