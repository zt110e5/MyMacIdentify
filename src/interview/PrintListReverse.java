import java.util.ArrayList;
import java.util.Stack;
/*
从尾到头打印链表
 */
public class PrintListReverse {
    public static void main(String[] args) {
        ListNode2 l1 = new ListNode2();
        ListNode2 l2 = new ListNode2();
        ListNode2 l3 = new ListNode2();
        ListNode2 l4 = new ListNode2();
        l1.data = 1;
        l2.data = 2;
        l3.data = 3;
        l4.data = 4;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        printlistreverse1(l1);
        ArrayList<Integer> lists = printlistreverse2(l1);
        for (int i:
             lists) {
            System.out.println(i);
        }
    }


    //采用栈，未采用递归的方式
    public static void printlistreverse1(ListNode2 headNode){
        Stack<ListNode2> stack = new Stack<>();
        while (headNode!=null){
            stack.push(headNode);
            headNode = headNode.next;
        }

        while (!stack.empty())
            System.out.println(stack.pop().data);
    }

    //采用递归的方式,递归代码虽然更简单，但是当链表非常长的时候，会导致函数调用层级很深，例如利用递归调用斐波那契数列时候，计算10000以上的
    //斐波那契数耗时很久；而且很有可能导致函数调用栈溢出。
    //显然用栈基于循环实现的代码的鲁棒性更好一些（方法1）。
    public static ArrayList<Integer> printlistreverse2(ListNode2 headNode){
        ArrayList<Integer> list=new ArrayList<Integer>();
        if (headNode != null) {
            if (headNode.next != null)
                list = printlistreverse2(headNode.next);
            list.add(headNode.data);
        }
        return list;
    }
}
