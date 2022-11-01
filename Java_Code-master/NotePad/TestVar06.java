public class TestVar06 {
	public static void main (String [] arges){
	//定义字符类型的变量:
	char chi = 'a';
	System.out.println(chi);
	char ch2 = 'A';
	System.out.println(ch2);
	char ch3 = '3';
	System.out.println(ch3);
	char ch4 = '$';
	System.out.println(ch4);
	char ch5 = '牛';
	System.out.println(ch5);
	char ch6 = ' ';  //字符串引起类的单个字符
	System.out.println(ch6);
	System.out.println ("---------------------");
	/*
	转译字符:
	\  将后面的普通字符转化为特殊含义
	*/
	char ch7 = '\n';
	System.out.println("aaa"+ch7+"bbb");
	System.out.println("aaa\nbbb");  //  \n换行
	System.out.println("aaaaa\rbbb");  //  \r相当于回车	
	System.out.println("aaaaaaaa\tbbbbbb");  //  \t  制表符
	System.out.println("aaa\bbbb");// \b 退一个格
	System.out.println("\"你好java\"");
	System.out.println("\\你好\\"); 
	
	}
}