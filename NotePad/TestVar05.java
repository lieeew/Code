public  class TestVar05{
	public static void main (String [] arges){
		double num1 = 3.14;//10进制
		System.out.println(num1);
		double num2 = 314E-2;//科学计数法
		System.out.println(num2);
		//类型的变量
		// 注意: 浮点默认是double ,要想将一个double类型的赋给float后面加一个f或F
		float num3 = 3.1415926545964F;
		System.out.println(num3);
		float num4 = 314e-2f;
		double num5 = 3.14;
		System.out.println(num4 == num5);  //结果为false
		/*
		区别
		= 为赋值运算
		==判断是否相等:  结果要么是true要么是false
		*/
		
	}
}