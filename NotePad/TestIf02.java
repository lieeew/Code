import java.util.*;
public class TestIf02{
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
	if(sum > 14){
		System.out.println("��ϲ����һ�Ƚ�!");
	} else if(sum > 10){//������sum<14
		System.out.println("��ϲ���ö��Ƚ�!");
	} else if(sum >= 6){/������sum<10
		System.out.println("��ϲ�������Ƚ�!");	
	}else {//������sum<6
		System.out.println("�ٽ�����");
	}
	
	}
}
/* ��2��else:������һ���������������֧��������ʽ�෴�Ĺ��� (����������)
   ��3�����֧���ô���ֻҪ����һ�� ��֧�Ժ󣬺���ķ�֧�Ͳ���Ҫ�ж��� --��Ч�ʸ�
   ��4������д�����ʱ�򣬾�����֤else�Ĵ���--��else��֧�൱�ڡ����ס�����̥�������ã���ķ�֧�����ߣ��ͻ��������֧��*/
   