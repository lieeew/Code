public class TestVar09{
	public static void main (String [] arges){
		double d = 6;   //intת��Ϊdouble����
		System.out.println(d);
		int i = (int)6.5;  //doubleת��Ϊint������,��Ҫ��ǰ���(int)   ������ǰ�С�����Ժ��ȥ��
		System.out.println(i);
		double d2 = 12+1294L+8.5F+3.81+'a';
		System.out.println(d2);
		 /*
           ���ͼ���(�ӵ͵��ߵ�)
           byte,short,char-->int--->long--->float--->double
           ��������ʲô����һ�����ʽ���ж����������͵�ʱ��Ҫ�ҳ���ǰ���ʽ�м�����ߵ��Ǹ����ͣ�Ȼ��
           ��������Ͷ�ת��Ϊ��ǰ���ʽ�м�����ߵ����ͽ��м��㡣
           double d2 = 12+1294L+8.5F+3.81+'a';
                    = 12.0+1294.0+8.5+3.81+97.0
        */
		int i2 = (int)(12+1294L+8.5F+3.81+'a');
		System.out.println(i2);
		byte b1 = 127;
		System.out.println(b1);
		byte b2 = (byte)129;
		System.out.println(b2);
		
	}
}