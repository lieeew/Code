package Day13exer.MarkDown.Day16;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/26 - 09 - 26
 * @Description: Day16
 */

/**
 * 如何自定义异常类?
 * 1. 首先要继承于异常类 , RuntimeException , Exception
 * 2.
 *
 */
public class MyException extends RuntimeException{

    static final long serialVersionUID = -7034897190945766939L;

    public MyException (String msg) {
        super(msg);
    }

}
