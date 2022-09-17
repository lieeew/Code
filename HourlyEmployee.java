package Day15exer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/14 - 09 - 14
 * @Description: Day15exer
 */
public class HourlyEmployee extends Employee{

    private double wage;
    private double hour;


    public HourlyEmployee(String name, int number, MyDate birthday, double wage, double hour) {
        super(name, number, birthday);
        this.hour = hour;
        this.wage = wage;
    }

    @Override
    public double earning() {

        return wage * hour;

    }
}
