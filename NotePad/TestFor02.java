public class TestFor02{
	public static void main(String[] arges){
	 //���ܣ���1-100�ĺͣ����͵�һ�γ���300��ʱ��ֹͣ����	
	int sum = 0;
	int i;
	for(i = 1;i <= 100;i++){
		sum += i;
		if(sum == 300){
			break;
		}
		}
		System.out.println(sum);
	}
}