

/*
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */

public class Merge {
    public ListNode2 merge(ListNode2 list1, ListNode2 list2){
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode2 mergeList = null;

        if (list1.data < list2.data){
            mergeList = list1;
            mergeList.next = merge(list1.next,list2);
        }else {
            mergeList = list2;
            mergeList.next = merge(list1,list2.next);
        }
        return mergeList;
    }
}
