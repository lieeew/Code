public class StudentTest02 {
    public static void main(String[] args) {
        Student02[] stu = new Student02[20];
        for (int a = 0; a < stu.length; a++) {
             stu[a] = new Student02();
            // �꼶
            stu[a].state = (int) (Math.random() * 6 + 1);
            // ����
            stu[a].score = (int) (Math.random() * 100);
            // ˳��
            stu[a].number = (a + 1);
        }
        StudentTest02 s = new StudentTest02();
        s.print(stu);
        System.out.println("***********");
        s.seartchState(stu, 3);
        System.out.println("**********");
        s.sort(stu);


    }

    /**
     * ����
     *
     * @param stu
     * @param num
     */
    public  void seartchState(Student02[] stu, int num) {
        for (int a = 0; a < stu.length; a++) {
            if (num == stu[a].state) {
                System.out.println(stu[a]);
            }
        }
    }


    /**
     * ð��������гɼ�������
     *
     * @param stu
     */
    public  void sort(Student02[] stu) { // ð������
        for (int a = 0; a < stu.length - 1; a++) {
            for (int j = 0; j < stu.length - 1 - a; a++) {
                if (stu[j].score > stu[j + 1].score) {
                    Student02 num = stu[j];
                    stu[j] = stu[j + 1];
                    stu[j + 1] = num;
                }
            }
        }
        for (int c = 0; c < stu.length; c++) {
            System.out.println("�ɼ�Ϊ:" + stu[c].score + "\t�꼶:" + stu[c].state + "\t���Ϊ" + stu[c].number);
        }
    }

    /**
     * ��������
     *
     * @param stu
     */
    public  void print(Student02[] stu) {
        for (int a = 0; a < stu.length; a++) {
            System.out.println("�ɼ�Ϊ:" + stu[a].score + "\t�꼶:" + stu[a].state + "\t���Ϊ" + stu[a].number);
        }
    }

    class Student02 {
        int number;
        int state;
        int score;

        public String inforr() {
            return "�ɼ�Ϊ:" + score + "\t�꼶:" + state + "\t���Ϊ" + number;
        }
    }
}


