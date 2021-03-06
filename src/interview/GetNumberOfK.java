/**
 * 统计一个数字在排序数组中出现的次数。
 * 思路：已排序好的，所以使用二分查找方法定位k的第一次出现位置和最后一次出现位置
 */
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        int alength = array.length;
        if (alength == 0)
            return 0;
        int firstK = getFirstK(array,k,0,alength - 1);
        int lastK = getLastK(array,k,0,alength -1);
        if (firstK != -1 && lastK != -1)
            return lastK - firstK + 1;
        return 0;
    }



    //递归写法--->获取第一个K
    private int getFirstK(int [] array , int k, int start, int end){
        if (start > end)
            return -1;
        int mid = (start + end) >> 1;
        if (array[mid] > k){
            return getFirstK(array,k,start,mid - 1);
        }else if (array[mid] < k){
            return getFirstK(array,k,mid + 1,end);
        }else if (mid - 1 >= 0 && array[mid - 1] == k){
            return getFirstK(array,k,start,mid - 1);
        }else
            return mid;
    }


    //循环写法---》获取最后的一个k
    private int getLastK(int [] array , int k, int start, int end){
        int length = array.length;
        int mid = (start + end) >> 1;
        while (start <= end){
            if (array[mid] > k){
                end = mid - 1;
            }else if (array[mid] < k){
                start = mid + 1;
            }else if (mid + 1 < length && array[mid + 1] == k){
                start = mid + 1;
            }else {
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
    }
}
