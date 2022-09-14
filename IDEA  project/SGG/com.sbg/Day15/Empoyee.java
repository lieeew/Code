package Day15;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/13 - 09 - 13
 * @Description: Day15
 */
abstract public class Empoyee {

    private String name;
    private int id;
    private double salary;

    public Empoyee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public Empoyee() {
    }

    public abstract void work ();
}


