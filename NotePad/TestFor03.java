public class TestFor03{
	public static void main(String[] arges){
		int sum = 0;
		int i;
		outer:
		for (i = 0;i <= 100 ; i++){
			System.out.println(i);  //�����i��30
			while (i == 30){
				break outer;
			}
			System.out.println(i);  //�����iû��30			
		}
	}
}