import java.util.*;  //* 代表所有
public class TestOpe12{
	public static void main (String[] arges){
		//实现功能：男孩女孩选择晚饭吃什么，如果意见一致，听男生的，如果意见不一致，听女生的
		Scanner input = new Scanner(System.in);
		System.out.println("请选择今晚吃什么：1.火锅 2.烧烤 3.麻辣烫 4.西餐");
		System.out.println("请男孩输入:");
		int BoyChoice = input.nextInt();
		System.out.println("请女孩输入:");
		int GrilChoice = input.nextInt(); 
		System.out.println(GrilChoice == BoyChoice?"听男孩":"听女孩" );
	}
}