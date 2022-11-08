package Day23;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/6 - 11 - 06
 * @Description: Day23
 */
public class LinkListTest {
    public static void main(String[] args) {
        // 模拟一个简单的双向链表
        Node jck = new Node("Jck");
        Node tom = new Node("Tom");
        Node hsp = new Node("hsp");

        jck.next = tom;
        tom.next = hsp;

        hsp.pre = tom;
        tom.pre = jck;

        Node first = jck;
        Node last = hsp;
        // 输出数组中的元素
        // 从头遍历
        System.out.println("==从头遍历==");
        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next; // 把指针向后移
        }

        // 从后遍历
        /*System.out.println("==从后遍历==");
        while (true) {
            if (last == null) {
                break;
            }
            System.out.println(last);
            last = last.pre; // 指针向前移动
        }*/

    }
}


// 定义一个双向链表节点的对象
class Node {
    public Object itm; // 真正的数据
    public Node next; // 指向下一个节点
    public Node pre; // 指向上一个节点

    public Node(Object name) {
        this.itm = name;
    }

    @Override
    public String toString() {
        return "Node name = " + itm;
    }
}