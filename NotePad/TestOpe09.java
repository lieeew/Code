// &，|，?&&，||，!，^
public class TestOpe09{
	public static void main(String[] arges){
	//  逻辑与: &规律:自要有一个操作是false,那么结果就一定是false
	System.out.println(false & true);
	System.out.println(false & false);
	System.out.println(true & true);
	System.out.println(true & false);
	// 短路与 :&& 规律:效率高一些，只要第一个表达式是false，那么第二个表达式就不用计算了，结果一定是false
	System.out.println("--------------------------");
	System.out.println(true && true);
	System.out.println(false && true);
	System.out.println(false && false);
	System.out.println(true && false);
	// 逻辑或 : |  规律：只要有一个操作数是true，那么结果一定是true
	System.out.println("--------------------------");
	System.out.println(true | false);
	System.out.println(false | true);
	System.out.println(true | true);
	System.out.println(false |false);
	// 短路或：|| 规律：效率高一些，只要第一个表达式是true，那么第二个表达式就不用计算了，结果一定是true
	System.out.println("--------------------------");
	System.out.println(true || false);
	System.out.println(false || true);
	System.out.println(true || true);
	System.out.println(false ||false);
	//逻辑非：   !  规律：相反结果
	System.out.println("-------------------------");
	System.out.println(!false);
	System.out.println(!true);
	//逻辑异或： ^  规律：两个操作数相同，结果为false，不相同，结果为true
	System.out.println("-------------------------");
	System.out.println(true^true);
	System.out.println(true^false);
	System.out.println(false^true);
	System.out.println(false^false);
	}
 }