public class TestVar03 {
	public static void main(String[] arges){
		int num1 = 10 , num2 = 20;  // num1  和num2 都为int类型!
		;
		num1  = num2;
		num2  = num2+10;
		num1 = num2 -10;
		num2 = num1;
		System.out.println("num1=" + num1);
		System.out.println("num2=" + num2);
	}
}