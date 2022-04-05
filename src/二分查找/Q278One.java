package 二分查找;

public class Q278One {
    public int firstBadVersion(int n) {
        int left = 0, right = n;
        while (left < right){
            int mid = (right - left)/2 + left;
//            如果他是坏的，那么他前面也有可能是坏的但是也有可能他就是第一个坏的，所以right = mid；
//            缩减右区间不影响当前元素是否是第一个坏的
//            如果他不是坏的，那么他前面一定都是好的
            if (!isBadVersion(mid)){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
    private boolean isBadVersion(int mid) {
        return true;
    }
}
