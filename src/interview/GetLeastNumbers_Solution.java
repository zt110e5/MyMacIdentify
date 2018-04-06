import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        //调用了Arrays.sort()方法：
//        Arrays.sort(input);
//        if (k > input.length){
//            for (int i = 0;i < input.length; i++){
//                arrayList.add(input[i]);
//            }
//            return arrayList;
//        }
//        for (int i = 0; i < k; i++){
//            arrayList.add(input[i]);
//        }

        //2。利用最大堆保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。
        int length = input.length;
        if (k > length || k == 0)
            return arrayList;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length; i++){
            if (maxHeap.size() != k){
                maxHeap.offer(input[i]);
            }else if (maxHeap.peek() > input[i]){
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        for (Integer i :
             maxHeap) {
            arrayList.add(i);
        }


        return arrayList;
    }
}
