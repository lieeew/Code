package MarkdownTest02;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/11 - 09 - 11
 * @Description: MarkdownTest02
 */
public class CustomerView {
    CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer cus = new Customer("lihua", 18, '女',"10086" , "lihua@gamil.com");
        customerList.addCustomer(cus);
    }
    boolean isflage;
    public void enterMainMenu() {
        isflage = true;
        while (isflage) {

            System.out.println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");
            char meu = CMUtility.readMenuSelection();
            switch (meu) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.println("确定是否退出");
                    char c = CMUtility.readConfirmSelection();
                    if (c == 'Y') {
                        System.out.println("退出成功");
                        isflage = false;
                    }
            }
        }
    } // 代码优化 ctrl + alt + l

    /**
     * 添加用户
     */
    private void addNewCustomer(){

        System.out.println("---------添加客户------");
        System.out.println("姓名:" );
        String name = CMUtility.readString(7);
        System.out.println("性别:" );
        char gender = CMUtility.readChar();
        System.out.println("年龄 :" );
        int age = CMUtility.readInt();
        System.out.println("电话 :");
        String phone = CMUtility.readString(10);
        System.out.println("邮箱 :");
        String email = CMUtility.readString(14);
        Customer customer = new Customer(name, age, gender, phone, email);
        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }


    /**
     * 修改用户信息
     */
    private void modifyCustomer(){

        System.out.println("---修改客户---");
        System.out.println("请输入需要修改的编号.");
        int num = CMUtility.readInt();
        Customer cus = customerList.getCustomer(num - 1);
        System.out.println("姓名 (" + cus.getName() + ")");
        String name = CMUtility.readString(5, cus.getName());
        System.out.println("年龄 (" + cus.getAge() + ")");
        int age = CMUtility.readInt();
        System.out.println("性别 (" +cus.getGender() + ")");
        char gender = CMUtility.readChar();
        System.out.println("电话 (" + cus.getPhone() + ")");
        String phone = CMUtility.readString(10,cus.getPhone());
        System.out.println("邮箱 (" + cus.getEmail() + ")");
        String email = CMUtility.readString(10,cus.getEmail());
        Customer customer = new Customer(name, age, gender, phone, email);
        boolean isSuccess = customerList.replaceCustomer(num - 1, customer);
        if (isSuccess) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }

    }


    /**
     * 删除用户
     */
    private void deleteCustomer(){

        System.out.println("------删除用户-------");
        int num ;
        Customer cus;
        for (;;) {
            System.out.println("删除与用户的编号(-1退出)");
            num = CMUtility.readInt();
            if (num == -1) {
                return;
            }
            cus = customerList.getCustomer(num - 1);
            System.out.println("请输入要删除的序号:");
            if (cus == null) {
                System.out.println("没有找到该用户");
                return;
            }
            break;
        }

        System.out.println("确认是否删除(Y/N)：");
        char choice = CMUtility.readConfirmSelection();
        if (choice == 'Y') {
            boolean isSuccess = customerList.deleteCustomer(num - 1);
            if (isSuccess) {
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        } else {
            return;
        }
    }


    /**
     * 客户列表
     */

    private void listAllCustomers(){

        System.out.println("---------------------------客户列表---------------------------");
        int total = customerList.getTotal();
        if (total == 0) {
            System.out.println("无数据");
        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t邮箱");
            for (int a = 0; a < total; a ++) {
                Customer cus = customerList.getCustomer(a);
                System.out.println((a + 1) + "\t" + cus.getName() + "\t" + cus.getGender() + "\t" + cus.getAge() +
                        "\t\t" + cus.getPhone() + "\t\t" + cus.getEmail());
            }
        }
        System.out.println("-------------------------客户列表完成-------------------------");
    }


    public static void main(String[] args) {
        CustomerView View = new CustomerView();
        View.enterMainMenu();
    }

}
