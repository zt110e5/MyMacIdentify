public class MinNumberInRotateArray {
    /*
    旋转数组的最小数字
     */
    public int minNumberInRotateArray(int [] array) {
        if (array.length==0)
            return 0;

        int index1 = 0;
        int index2 = array.length-1;
        int indexmid = index1;

        while (array[index1] >= array[index2]){
            if (index2-index1==1){
                indexmid = index2;
                break;
            }
            /*
            indexmid = (index1 + index2)/2;
            if (array[indexmid]>= array[index1])
                index1 = indexmid;
            else if (array[index2] >= array[indexmid])
                index2 = indexmid;
                */
            //当输入数据为{1,0,1,1,1}时，此方法健壮性不足，无法区分第一个1，第三个1和第5个1，此时必须采用顺序查找的方法。
            indexmid = (index1 + index2)/2;
            if (array[index1] == array[index2] && array[index1] == array[indexmid])
                return MinInOrder(array,index1,index2);

            if (array[indexmid]>= array[index1])
                index1 = indexmid;
            else if (array[index2] >= array[indexmid])
                index2 = indexmid;
        }
        return array[indexmid];
    }

    public int MinInOrder(int [] array,int index1,int index2){
        int result = array[index1];
        for (int i = index1+1;i<index2;i++){
            if (result > array[i])
                result = array[i];
        }
        return result;
    }
}
