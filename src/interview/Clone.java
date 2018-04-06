/**
 * 复杂链表的复制：
 * 输入一个复杂链表
 * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
/**
 * 思路1：分两步，第一步：复制原始链表上的每个节点，并用pNext串起来；
 *              第二步：设置每个节点的随机指针。
 *              采用从头遍历的方式，此方法时间复杂度O(n^2)
 * 思路2：分两步，第一步：复制原始链表上的每个节点，并用pNext串起来；
 *              第二步：设置每个节点的随机指针。
 *              与第一步不同的是，我用哈希表<N,N'>将每个复制节点保存下来，如果在原始链表中的N随机指向了S，则在复制链表中的N'随机指向了S'；
 *              这时，有了哈希表，我就可以用O(1)的时间根据S找到S'.相当于空间O(n)换时间O(n).
 * 思路3：分三步，第一步：复制原始链表上的每个节点，将新复制的节点N'链接到原来的N后面;
 *              第二步：设置每个节点的随机指针。（如果原始链表上的N的随机指针指向了节点S，则对应复制出来的N'指向了S的下一个节点）
 *              第三步：把长链表拆分成两个链表。奇数为一个链表，偶数项为复制的链表。。。
 */
public class Clone {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
//        CloneNodes(pHead);
//        ConnectSiblingNodes(pHead);
//        RandomListNode resultNode = ReconnectNodes(pHead);
        RandomListNode pCur = pHead;
        //复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
        while (pCur!=null){
            RandomListNode pClone = new RandomListNode(pCur.label);
            pClone.next = pCur.next;
            pCur.next = pClone;
            pCur = pClone.next;
        }

        pCur = pHead;
        //复制random pCur是原来链表的结点 pCur.next是复制pCur的结点
        while (pCur!= null){
            if (pCur.random != null){
                pCur.next.random = pCur.random.next;
            }
            pCur = pCur.next.next;
        }
        //拆分链表
        RandomListNode head = pHead.next;
        RandomListNode cur = head;
        pCur = pHead;
        while (pCur != null){
            pCur.next = pCur.next.next;
            if (pCur.next!=null){
                cur.next = cur.next.next;
            }
            cur = cur.next;
            pCur = pCur.next;
        }
        return head;
    }

    //复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
//    private void CloneNodes(RandomListNode pHead){
//
//        RandomListNode pnode = pHead;
//        while (pnode != null){
//            RandomListNode pclone = new RandomListNode(pnode.label);
//            pclone.next = pnode.next;
//            pclone.random = null;
//
//            pnode.next = pclone;
//            pnode = pclone.next;
//
//        }
//    }

    //复制random pCur是原来链表的结点 pCur.next是复制pCur的结点
//    private void ConnectSiblingNodes(RandomListNode phead){
//        RandomListNode pnode = phead;
//        while (pnode != null){
//            RandomListNode pclone = new RandomListNode(pnode.label);
//            if (pnode.random != null){
//                pclone.random = pnode.random.next;
//            }
//            pnode = pclone.next;
//        }
//    }
    //拆分链表
//    private RandomListNode ReconnectNodes(RandomListNode phead){
//        RandomListNode pnode = phead;
//        RandomListNode pCloneHead = null;
//        RandomListNode pCloneNode = null;
//
//        if (pnode != null){
//            pCloneHead = pCloneNode = pnode.next;
//            pnode.next = pCloneNode.next;
//            pnode = pnode.next;
//        }
//
//        while (pnode != null){
//            pCloneNode.next = pnode.next;
//            pCloneNode = pCloneNode.next;
//            pnode.next = pCloneNode.next;
//            pnode = pnode.next;
//        }
//        return  pCloneHead;
//    }
}
