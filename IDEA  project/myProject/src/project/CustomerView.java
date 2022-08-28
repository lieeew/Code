package project;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/26 - 08 - 26
 * @Description: project
 */
public class CustomerView {
    CustomerList customerList = new CustomerList(10);
    public CustomerView (){
        Customer cus = new Customer("lihua", '女', 18, "lihau@qq.com", "1212121");
        customerList.addCustomer(cus);
    }


    public void enterMainMenu() {
        boolean isFlage = true;
        while (isFlage) {
            System.out.println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");
            char emu = CMUtility.readMenuSelection();
            switch (emu) {
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
                    System.out.println("是否确认退出:");
                    char choice = CMUtility.readConfirmSelection();
                    if (choice == 'Y') {
                        isFlage = false;
                    }
            }
        }
    }



    private void addNewCustomer() {
        System.out.println("---------添加客户------");
        System.out.print("姓名:" );
        String name = CMUtility.readString(10);
        System.out.print("年龄:");
        int age = CMUtility.readInt();
        System.out.print("性别:");
        char sex = CMUtility.readChar();
        System.out.print("电话:");
        String phone = CMUtility.readString(15);
        System.out.print("邮箱:");
        String email = CMUtility.readString(15);
        Customer cus = new Customer(name, sex, age, email, phone);
        boolean isSuccess = customerList.addCustomer(cus);
        if (isSuccess) {
            System.out.println("添加成功!");
        } else {
            System.out.println("添加失败!");
        }
    }



    private void modifyCustomer() {
        System.out.println("--------修改用户信息-------");
        Customer cus = null;
        int num;
        for (;;) {
            num = CMUtility.readInt();
            if (num == -1) {
                System.out.println("找不到");
                break;
            }else {
                 cus = customerList.getCustomer(num - 1);
                break;
            }
        }
        System.out.println("姓名(" + cus.getName() + ")");
        String name = CMUtility.readString(10, cus.getName());
        System.out.println("年龄(" + cus.getAge() + ")");
        int age = CMUtility.readInt(10);
        System.out.println("邮箱(" + cus.getEmail() + ")");
        String email = CMUtility.readString(10, cus.getEmail());
        System.out.println("电话(" + cus.getPhone() + ")");
        String phone = CMUtility.readString(10, cus.getPhone());
        System.out.println("性别(" + cus.getSex() + ")");
        char sex = CMUtility.readChar(cus.getSex());
        Customer newCustomer = new Customer(name,sex,age,email, phone);
        boolean isGet = customerList.replaceCustomer(num - 1,newCustomer);
        if (isGet) {
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
    }


    private void deleteCustomer() {
        System.out.println("------删除用户-------");
        System.out.println("删除与用户的编号(-1退出)");
        Customer cus;
        int num = CMUtility.readInt();
        for ( ; ; ) {
            if (num == -1) {
                return;
            }
            cus = customerList.getCustomer(num );
            if (cus == null) {
                System.out.println("未找到该用户");
            }else {
                break;
            }
        }
        System.out.println("确认是否删除(Y/N)：");
        char choice = CMUtility.readConfirmSelection();
        if (choice == 'N') {
            return;
        }else {
            boolean b = customerList.deleteCustomer(num );
            if (b) {
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }
        }


    }
    private void listAllCustomers() {
        System.out.println("---------------------------客户列表---------------------------");
        Customer[] allCustomers = customerList.getAllCustomers();
        int num = customerList.getTotal();

        if (num == 0) {
            System.out.println("没有找到该用户");
        }else {
            System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t邮箱");
            for (int a = 0; a < num; a++) {
                System.out.println((a + 1) + "\t" + allCustomers[a].getName()
                        + "\t" + allCustomers[a].getAge() + "\t" + allCustomers[a].getPhone() +
                        "\t" + allCustomers[a].getEmail());
            }
        }
        System.out.println("-------------------------客户列表完成-------------------------");

    }

    public static void main(String[] args) {
        CustomerView cus = new CustomerView();
        cus.enterMainMenu();
    }


}
