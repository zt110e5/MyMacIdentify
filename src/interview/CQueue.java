import java.util.Stack;

public class CQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        CQueue cq = new CQueue();
        cq.push(1);
        cq.push(2);
        cq.push(3);
        cq.pop();
        cq.push(4);
        cq.pop();
    }
    public void push(int code){
        stack1.push(code);
    }

    public int pop(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        if (stack2.isEmpty()){
            try {
                throw new Exception("Stack2 is empty!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            return stack2.pop();
    }
}
