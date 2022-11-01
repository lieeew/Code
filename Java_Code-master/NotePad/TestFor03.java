public class TestFor03{
	public static void main(String[] arges){
		int sum = 0;
		int i;
		outer:
		for (i = 0;i <= 100 ; i++){
			System.out.println(i);  //输出的i有30
			while (i == 30){
				break outer;
			}
			System.out.println(i);  //输出的i没有30			
		}
	}
}