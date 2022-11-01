import java.util.*;
public class TestIf02{
	public static void main(String[] arges){
	Scanner sc = new Scanner(System.in);
	System.out.println("请输入三个数字:");	
	int num1 = sc.nextInt();
	int num2 = sc.nextInt();
	int num3 = sc.nextInt();
	int sum = 0;
	sum += num1;
	sum += num2;
	sum += num3;
	System.out.println("和为:"+sum);
	if(sum > 14){
		System.out.println("恭喜你获得一等奖!");
	} else if(sum > 10){//隐藏了sum<14
		System.out.println("恭喜你获得二等奖!");
	} else if(sum >= 6){/隐藏了sum<10
		System.out.println("恭喜你获得三等奖!");	
	}else {//隐藏了sum<6
		System.out.println("再接再厉");
	}
	
	}
}
/* 【2】else:隐藏了一个条件，跟上面分支条件表达式相反的功能 (详见数轴分析)
   【3】多分支：好处：只要满足一个 分支以后，后面的分支就不需要判断了 --》效率高
   【4】我们写代码的时候，尽量保证else的存在--》else分支相当于“兜底”“备胎”的作用，别的分支都不走，就会走这个分支了*/
   