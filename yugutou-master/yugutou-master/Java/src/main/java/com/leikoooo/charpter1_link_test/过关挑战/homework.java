package com.leikoooo.charpter1_link_test.过关挑战;

/**
 * @author leikooo
 * @create 2023-07-21 9:30
 * @Package com.leikoooo.charpter1_link_test.过关挑战
 * @Description
 */
public class homework {
    static class Student {
        String name;
        String language;
        Student next;

        public Student(String name, String language, Student next) {
            this.name = name;
            this.language = language;
            this.next = next;
        }

        public Student(Student next) {
            this.next = next;
        }

        public Student(String name, String language) {
            this.name = name;
            this.language = language;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", language='" + language + '\'' +
                    '}';
        }
    }

    /**
     * 初始化链表
     *
     * @param students
     * @return
     */
    public static Student initStudents(String[][] students) {
        Student cur = null, head = null;
        for (int i = 0; i < students.length; i++) {
            String[] student = students[i];
            if (i == 0) {
                // 头节点
                cur = new Student(student[0], student[1]);
                head = cur;
            } else {
                cur.next = new Student(student[0], student[1]);
                cur = cur.next;
            }
        }

        return head;
    }

    /**
     * 打印输出链表的值
     *
     * @param student 头节点
     * @return
     */
    public static String toString(Student student) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (student != null) {
            sb.append(student);
            student = student.next;
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");

        return sb.toString();
    }

    /**
     * 插入学生信息
     */
    public static Student changeStudent(Student student, Student... insertStudents) {
        Student java = student, cpp = student, python = student;
        Student dummyHead = new Student("", "");
        dummyHead.next = student;
        Student cur = dummyHead;
        while (cur.next != null && ("Java".equals(cur.next.language) || "Cpp".equals(cur.next.language) || "Python".equals(cur.next.language))) {
            if ("Java".equals(cur.next.language)) {
                java = cur.next;
                cur = cur.next;
            }

            if ("Cpp".equals(cur.next.language)) {
                cpp = cur.next;
                cur = cur.next;
            }

            if ("Python".equals(cur.next.language)) {
                python = cur.next;
                cur = cur.next;
            }
        }
        for (Student insertStudent : insertStudents) {
            if ("Java".equals(insertStudent.language)) {
                insertStudent.next = java.next;
                java.next = insertStudent;
                java = java.next;
            } else if ("Python".equals(insertStudent.language)) {
                insertStudent.next = python.next;
                python.next = insertStudent;
                python = python.next;
            } else {
                insertStudent.next = cpp.next;
                cpp.next = insertStudent;
                cpp = cpp.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        String[][] arrays = {{"aa", "Java"}, {"ab", "Java"},
                {"ba", "Cpp"}, {"bb", "Cpp"},
                {"ca", "Python"}, {"cb", "Python"}};

        Student student = initStudents(arrays);

        String string = toString(student);
        System.out.println("string = " + string);

        Student student1 = changeStudent(student, new Student("1", "Java"), new Student("4", "Java") ,new Student("2", "Cpp"), new Student("3", "Python"));
        System.out.println("toString(student1) = " + toString(student1));
    }
}
