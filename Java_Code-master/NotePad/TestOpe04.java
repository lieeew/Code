public class TestOpe04{
	public static void main (String[] arges){
	int a = 5;
	a ++;
	System.out.println(a);  //���Ϊ6
	int b = 5;
	++ b;
	System.out.println(b); //���Ϊ6
	//�ܽ᣺++����ʹ�õ�ʱ�����۷���ǰ���Ǻ󣬶��Ǽ�1����
                
    //��++���뵽�����У�
    //���򣺿�++��ǰ�����ں����++�ں������㣬���1   ���++��ǰ���ȼ�1��������
	a = 5;
	int m = a++ + 7;
	System.out.println(a);  //6
	System.out.println(m);  //12
	
	
	a = 5;
	int n = ++a + 7;
	System.out.println(a); //6
	System.out.println(n);  //13
	}
}