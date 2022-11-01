package Day17.study;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/8 - 10 - 08
 * @Description: Day17
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        MyThreead myThreead = new MyThreead();
        myThreead.start();
        for (int a = 0; a < 100; a++) {
            System.out.println("****");
        }
    }

}

class MyThreead extends Thread {

    @Override
    public void run() {
        for (int a = 0; a <101; a++) {
            if (a % 2 == 0) {
                System.out.println(a);
            }
        }
    }
}