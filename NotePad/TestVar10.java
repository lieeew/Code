import java.util.Scanner;    //�������⣺��java.util�½�Scanner�ù�����
public class TestVar10{
	public  static  void main(String [] arges){
	//ʵ�ֹ��ܣ���Բ���ܳ������
    //��1����ȡ��������ȡ����������Ϊ��һ�����ݣ��Ժ�ֻҪ�ı������ֵ������ֻҪ�õ���������ĵط���ȡֵҲ�������仯��
    //��2��һ��������final���Σ���������ͱ����һ�����������������ֵ�Ͳ��ɱ���
    //     �����������������˵�� �ַ�����  ---��pi
    //     Լ���׳ɵĹ涨���ַ�����������ȫ����д
    //��3��ʹ��ɨ������Scanner��ʹ��--��ע��ͨ�����������ȥʹ��	
	final double PI = 3.14;    //�ַ�������һ��final�Ͳ��ڸı�
	Scanner sc = new Scanner(System.in);  //��һ��ɨ����
	System.out.println("������뾶:");
	int r = sc.nextInt();  //��ɨ����ɨ�����¼���int���͵����ݣ�
	double c = 2*PI*r;   //���ܳ�
	System.out.println("�ܳ�Ϊ:"+c);
	double s = PI*r*r;    //�����
	System.out.println("���Ϊ:"+s);
	}
}






