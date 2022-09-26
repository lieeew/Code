package Day16;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/26 - 09 - 26
 * @Description: Day16
 */

/**
 *
 * 手动抛出一个异常(throw)
 */
public class throwTest {
    public static void main(String[] args) {

        Student s = new Student();
        try {
            s.register(-1922);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(s.toString());

    }
}


class Student {

    private int id;

    public void register (int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else {
//            System.out.println("非法数据");
            // 手动抛出对象
            throw new Exception("非法数据");

        }
    }


    @Override
    public String toString() {
        return "Student [" + "id =" + id + "]";
    }
}