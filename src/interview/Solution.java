import java.util.*;
/*
定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class Solution {
    /*
    借用辅助栈存储min的大小，自定义了栈结构
    方法：两个栈，一个放数据，一个放最小值，每次push一个数据，在最小值栈里push一个最小值；
    每次弹出一个数据，最小值栈利也弹出一个数据。
     */

    private Stack<Integer> minstack = new Stack<>();
    private Stack<Integer> datastack = new Stack<>();
    public void push(int node){
        datastack.push(node);
        if (minstack.isEmpty() && node< minstack.peek()){
            minstack.push(node);
        }else {
            minstack.push(minstack.peek());
        }
    }
    public void pop() {
        datastack.pop();
        minstack.pop();
    }

    public int top() {
        return datastack.peek();
    }

    public int min() {
        return minstack.peek();
    }
}
