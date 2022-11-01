public class TestVar07{
	public static void main(String [] arges){
	char ch1 = 'A';	
	System.out.println(ch1);
	System.out.println(ch1 + 90);
	//char类型我们看到的样子就是它本身的字面常量,但是底层在进行计算的时候，实际上是按照一个码进行计算的。
    //这个码就是ASCII
    //之前说char类型是按照Unicode码表进行存储的 (Unicode兼容了ASCII码，Unicode的前128位置ASCII)
	
	
	//转换
	char ch2 = '中';
	int num1 = ch2;  //20013
	System.out.println(num1);
	char ch = 20013;
	System.out.println(ch);
	int num2 = '中';
	System.out.println(num2);
	char ch5 = 20013;
	System.out.println(ch5);   //结果是 中 
	//面试题
	char ch6 = '2'+2;
	System.out.println(ch6);   //结果为 4
	}
}