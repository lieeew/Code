public class TestOpe03{
	public static void main(String[] arges ){
		System.out.println(+5);
		System.out.println(5+6);
		System.out.println(5+'6');
		//�ַ�����ƴ�ӣ�
        //����+�������������һ�����ַ�������ô����Ӻž����ַ���ƴ�ӵ����ã����һ�����ַ���
		int num = 56;
		System.out.println("num="+num);//"num=56" ---> num=56
        System.out.println(5+6+"7");//11+"7"--->"117"  --->117
        System.out.println(5+'6'+"7");//59 +"7"--->"597" --->597
        System.out.println("5"+6+"7");//"56"+"7"  --->"567"--->567
        System.out.println("5"+'6'+"7");//"56"+"7"--->"567"--->567
        System.out.println("5"+'6'+'7');//"56"+'7'--->"567"---567
		
	}
}