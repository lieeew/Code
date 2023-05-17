package easyAlgorithms;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/10/31 - 10 - 31
 * @Description: easyAlgorithms
 */
public class a2 {
    public static void main(String[] args) {
        Status status = Status.BASUY;
        System.out.println(status);

        System.out.println("**************");

        Status[] values = Status.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }
}

enum Status {

    BASUY("繁忙"), VOCATION("度假"), FREE("空闲");

    private String Status;

    private Status(String status) {
        Status = status;
    }


}