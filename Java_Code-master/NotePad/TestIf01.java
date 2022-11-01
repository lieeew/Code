public class TestIf01{
	public static void main (String[] arges){
	//实现一个功能：给出三个数（1-6），对三个数求和计算，根据和的大小来分配不同的奖品
	int num1 = 2;
	int num2 = 3;
	int num3 = 1;
	int sum = 0;
	sum += num1;
	sum += num2;
	sum += num3;
	System.out.println("和为:"+sum);
	if (sum >= 10){
		System.out.println("一等奖");
		System.out.println("恭喜你得到一等奖!");  //如果不加花括号,第一句判断自能作用到他的下一句
	}
	
	if (sum >= 5&& sum <= 10 ){
		System.out.println("二等奖");
	}
	if (sum < 2 && sum < 5){
		System.out.println("三等奖");
	}
	}
}