public class TestOpe04{
	public static void main (String[] arges){
	int a = 5;
	a ++;
	System.out.println(a);  //结果为6
	int b = 5;
	++ b;
	System.out.println(b); //结果为6
	//总结：++单独使用的时候，无论放在前还是后，都是加1操作
                
    //将++参与到运算中：
    //规则：看++在前还是在后，如果++在后：先运算，后加1   如果++在前，先加1，后运算
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