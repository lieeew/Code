public class TestOpe10{
	public static void main (String[] arges){
	int i=8;
    System.out.println((5>7)&&(i++==2)); //false
	System.out.println(i);  //8
	
	int a=8;
    System.out.println((5>7)&(a++==2)); //false
    System.out.println(a); //9
                
                
   int m=8;
   System.out.println((5<7)&&(m++==2)); //false
   System.out.println(m); //9
                
   int b=2;
   System.out.println((5<7)&(b++==2));  //ture
   System.out.println(b);  //3
                
   int c=2;
   System.out.println((5<7)&(++c==2)); //false
   System.out.println(c); //3
	}
}