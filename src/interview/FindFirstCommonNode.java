import java.util.Stack;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * 思路：(1)如果两个链表有公共节点，则这两个链表从这个节点以后的节点都是一样的。
 *      我们可以用两个栈装这两个链表，然后Pop()，直到两个stack中的值不一致为止。
 *      (2)还可以用hashmap存储其中一个链表，之后顺序遍历另外一个链表，如果链表中的节点在这个hashmap中，则返回。
 *      （3）先求出两个链表的长度差，然后让长的链表先走两个链表的长度差，然后再一起走
 *      （4）用两个指针扫描”两个链表“，最终两个指针到达 null 或者到达公共结点。
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while (pHead1 != null){
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null){
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode commonNode = null;
        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek()){
            stack1.pop();
            commonNode = stack2.pop();
        }
        return commonNode;
    }

    //用两个指针扫描”两个链表“，最终两个指针到达 null 或者到达公共结点。
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != p2){
            p1 = (p1 == null ? pHead2 : p1.next);
            p2 = (p2 == null ? pHead1 : p2.next);
        }

        return p1;
    }
}
