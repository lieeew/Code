package Day12Exercise;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/30 - 08 - 30
 * @Description: Day12Exercise
 */
public class Mankind {
    private int sex; // 性别
    private int salary; // 薪资
    public void setSex (int sex) {
        this.sex = sex;
    }
    public int getSex () {
        return sex;
    }
    public void setSalary (int salary) {
        this.salary = salary;
    }
    public int getSalary () {
        return salary;
    }
    public void manOrwoman () {
        //int sex1 = getSex(); // 不用写,可以直接用
        if (sex == 1) {
            System.out.println("man");
        }else {
            System.out.println("woman");
        }
    }
    public void empoyeed () {
        // int salary1 = getSalary();
        if (salary == 0) {
            System.out.println("no jab");
        }else {
            System.out.println("hava jab");
        }
    }
    public void empoyeed1 () {
        String jobInfo = (salary == 0) ? "no jab" : "jab";
        System.out.println(jobInfo);
    }
}
