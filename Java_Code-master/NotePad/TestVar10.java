import java.util.Scanner;    //形象理解：在java.util下将Scanner拿过来用
public class TestVar10{
	public  static  void main(String [] arges){
	//实现功能：求圆的周长和面积
    //【1】提取变量：提取变量，就是为了一劳永逸，以后只要改变变量的值，下面只要用到这个变量的地方，取值也都发生变化了
    //【2】一个变量被final修饰，这个变量就变成了一个常量，这个常量的值就不可变了
    //     这个常量就是我们所说的 字符常量  ---》pi
    //     约定俗成的规定：字符常量的名字全部大写
    //【3】使用扫描器：Scanner的使用--》注意通过形象的理解去使用	
	final double PI = 3.14;    //字符常量加一个final就不在改变
	Scanner sc = new Scanner(System.in);  //拿一个扫描器
	System.out.println("请输入半径:");
	int r = sc.nextInt();  //让扫描器扫描键盘录入的int类型的数据：
	double c = 2*PI*r;   //求周长
	System.out.println("周长为:"+c);
	double s = PI*r*r;    //求面积
	System.out.println("面积为:"+s);
	}
}







