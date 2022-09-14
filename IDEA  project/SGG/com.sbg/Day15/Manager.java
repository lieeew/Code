package Day15;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/13 - 09 - 13
 * @Description: Day15
 */
public class Manager extends Empoyee{

    private double bonus;

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public Manager(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("管理员工");
    }
}
