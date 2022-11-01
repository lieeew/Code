public class TestVar09{
	public static void main (String [] arges){
		double d = 6;   //int转化为double可以
		System.out.println(d);
		int i = (int)6.5;  //double转化为int不可以,需要在前面加(int)   结果就是把小数点以后的去掉
		System.out.println(i);
		double d2 = 12+1294L+8.5F+3.81+'a';
		System.out.println(d2);
		 /*
           类型级别：(从低到高的)
           byte,short,char-->int--->long--->float--->double
           别用来做什么？当一个表达式中有多种数据类型的时候，要找出当前表达式中级别最高的那个类型，然后
           其余的类型都转换为当前表达式中级别最高的类型进行计算。
           double d2 = 12+1294L+8.5F+3.81+'a';
                    = 12.0+1294.0+8.5+3.81+97.0
        */
		int i2 = (int)(12+1294L+8.5F+3.81+'a');
		System.out.println(i2);
		byte b1 = 127;
		System.out.println(b1);
		byte b2 = (byte)129;
		System.out.println(b2);
		
	}
}