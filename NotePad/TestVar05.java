public  class TestVar05{
	public static void main (String [] arges){
		double num1 = 3.14;//10����
		System.out.println(num1);
		double num2 = 314E-2;//��ѧ������
		System.out.println(num2);
		//���͵ı���
		// ע��: ����Ĭ����double ,Ҫ�뽫һ��double���͵ĸ���float�����һ��f��F
		float num3 = 3.1415926545964F;
		System.out.println(num3);
		float num4 = 314e-2f;
		double num5 = 3.14;
		System.out.println(num4 == num5);  //���Ϊfalse
		/*
		����
		= Ϊ��ֵ����
		==�ж��Ƿ����:  ���Ҫô��trueҪô��false
		*/
		
	}
}