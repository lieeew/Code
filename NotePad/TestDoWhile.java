public class TestDoWhile{
	public static void main(String[] arges){
		/*int num = 1;
		int sum = 0;
		while (num <= 100){
			sum += num;
			num++;
		}
		System.out.println(sum);*/
		int num = 1;
		int sum = 0;
		do{
			sum += num;
			num++;
		}while(num < 101);
		System.out.println(sum);
	}
}