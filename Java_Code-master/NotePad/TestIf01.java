public class TestIf01{
	public static void main (String[] arges){
	//ʵ��һ�����ܣ�������������1-6��������������ͼ��㣬���ݺ͵Ĵ�С�����䲻ͬ�Ľ�Ʒ
	int num1 = 2;
	int num2 = 3;
	int num3 = 1;
	int sum = 0;
	sum += num1;
	sum += num2;
	sum += num3;
	System.out.println("��Ϊ:"+sum);
	if (sum >= 10){
		System.out.println("һ�Ƚ�");
		System.out.println("��ϲ��õ�һ�Ƚ�!");  //������ӻ�����,��һ���ж��������õ�������һ��
	}
	
	if (sum >= 5&& sum <= 10 ){
		System.out.println("���Ƚ�");
	}
	if (sum < 2 && sum < 5){
		System.out.println("���Ƚ�");
	}
	}
}