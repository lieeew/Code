// &��|��?&&��||��!��^
public class TestOpe09{
	public static void main(String[] arges){
	//  �߼���: &����:��Ҫ��һ��������false,��ô�����һ����false
	System.out.println(false & true);
	System.out.println(false & false);
	System.out.println(true & true);
	System.out.println(true & false);
	// ��·�� :&& ����:Ч�ʸ�һЩ��ֻҪ��һ�����ʽ��false����ô�ڶ������ʽ�Ͳ��ü����ˣ����һ����false
	System.out.println("--------------------------");
	System.out.println(true && true);
	System.out.println(false && true);
	System.out.println(false && false);
	System.out.println(true && false);
	// �߼��� : |  ���ɣ�ֻҪ��һ����������true����ô���һ����true
	System.out.println("--------------------------");
	System.out.println(true | false);
	System.out.println(false | true);
	System.out.println(true | true);
	System.out.println(false |false);
	// ��·��|| ���ɣ�Ч�ʸ�һЩ��ֻҪ��һ�����ʽ��true����ô�ڶ������ʽ�Ͳ��ü����ˣ����һ����true
	System.out.println("--------------------------");
	System.out.println(true || false);
	System.out.println(false || true);
	System.out.println(true || true);
	System.out.println(false ||false);
	//�߼��ǣ�   !  ���ɣ��෴���
	System.out.println("-------------------------");
	System.out.println(!false);
	System.out.println(!true);
	//�߼���� ^  ���ɣ�������������ͬ�����Ϊfalse������ͬ�����Ϊtrue
	System.out.println("-------------------------");
	System.out.println(true^true);
	System.out.println(true^false);
	System.out.println(false^true);
	System.out.println(false^false);
	}
 }