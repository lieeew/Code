package Day33;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 * Created by shkstart.
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	@Test
	public void test1() {
		Consumer<String> consumer = str -> System.out.println(str);
		consumer.accept("北京");

		System.out.println("******************");

		PrintStream out = System.out;
		Consumer<String> consumer1 = out::println;
		consumer1.accept("beijing");
	}
	
	//Supplier中的T get()
	//Employee中的String getName()
	@Test
	public void test2() {
		Employee emp = new Employee(1001, "Tom", 23, 9000);
		Supplier<String> stringSupplier = () -> emp.getName();
		System.out.println(stringSupplier.get());
		System.out.println("********************");
		Supplier<String> stringSupplier1 = emp::getName;
		System.out.println(stringSupplier1.get());

	}

	// 情况二：类 :: 静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)
	@Test
	public void test3() {
		Comparator<Integer> comparator = (t1, t2) -> Integer.compare(t1, t2);
		System.out.println(comparator.compare(21, 23));

		System.out.println("************");

		Comparator<Integer> comparator1 = Integer::compare;
		System.out.println(comparator1.compare(32, 12));
	}
	
	//Function中的R apply(T t)
	//Math中的Long round(Double d)
	@Test
	public void test4() {
		Function<Double, Long> func = d -> Math.round(d);
		System.out.println(func.apply(12.3));

		System.out.println("**************");

		Function<Double, Long> func1 = Math::round;
		System.out.println(func1.apply(12.6));

	}

	// 情况三：类 :: 实例方法 
	// Comparator中的int comapre(T t1,T t2)
	// String中的int t1.compareTo(t2)
	@Test
	public void test5() {
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
		Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
		System.out.println(com1.compare("abc", "abd")); // 对应的ASIC码相减

		System.out.println("*************");

		Comparator<String> com2 = String::compareTo;
		System.out.println(com2.compare("abd", "abm"));
	}

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)
	@Test
	public void test6() {
		BiPredicate<String, String> predicate = (s1, s2) -> s1.equals(s2);
		System.out.println(predicate.test("abc", "abc"));

		System.out.println("****************");

		BiPredicate<String, String> predicate1 = String::equals;
		System.out.println(predicate1.test("abc", "abc"));

	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();
	@Test
	public void test7() {
		Employee employee = new Employee(1001, "Tom", 12, 320000);
		Function<Employee, String> function = e -> e.getName();
		System.out.println(function.apply(employee));

		System.out.println("***********");

		Function<Employee, String> function1 = Employee::getName;
		System.out.println(function1.apply(employee));
	}

}
