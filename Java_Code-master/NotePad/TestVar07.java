public class TestVar07{
	public static void main(String [] arges){
	char ch1 = 'A';	
	System.out.println(ch1);
	System.out.println(ch1 + 90);
	//char�������ǿ��������Ӿ�������������泣��,���ǵײ��ڽ��м����ʱ��ʵ�����ǰ���һ������м���ġ�
    //��������ASCII
    //֮ǰ˵char�����ǰ���Unicode�����д洢�� (Unicode������ASCII�룬Unicode��ǰ128λ��ASCII)
	
	
	//ת��
	char ch2 = '��';
	int num1 = ch2;  //20013
	System.out.println(num1);
	char ch = 20013;
	System.out.println(ch);
	int num2 = '��';
	System.out.println(num2);
	char ch5 = 20013;
	System.out.println(ch5);   //����� �� 
	//������
	char ch6 = '2'+2;
	System.out.println(ch6);   //���Ϊ 4
	}
}