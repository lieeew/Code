public class TestVar06 {
	public static void main (String [] arges){
	//�����ַ����͵ı���:
	char chi = 'a';
	System.out.println(chi);
	char ch2 = 'A';
	System.out.println(ch2);
	char ch3 = '3';
	System.out.println(ch3);
	char ch4 = '$';
	System.out.println(ch4);
	char ch5 = 'ţ';
	System.out.println(ch5);
	char ch6 = ' ';  //�ַ���������ĵ����ַ�
	System.out.println(ch6);
	System.out.println ("---------------------");
	/*
	ת���ַ�:
	\  ���������ͨ�ַ�ת��Ϊ���⺬��
	*/
	char ch7 = '\n';
	System.out.println("aaa"+ch7+"bbb");
	System.out.println("aaa\nbbb");  //  \n����
	System.out.println("aaaaa\rbbb");  //  \r�൱�ڻس�	
	System.out.println("aaaaaaaa\tbbbbbb");  //  \t  �Ʊ��
	System.out.println("aaa\bbbb");// \b ��һ����
	System.out.println("\"���java\"");
	System.out.println("\\���\\"); 
	
	}
}