package 双指针;

/**
 *  189.
 */

public class Q189Three {
        public void rotate(int[] nums, int k) {
            k = k%nums.length;
            reaverse(nums,0,nums.length-1);
            reaverse(nums,0,k-1);
            reaverse(nums,k,nums.length-1);
        }
        /* 该方法基于如下的事实：当我们将数组的元素向右移动k次后，尾部k个元素会移动至数组头部
        ，其余元素向后移动k个位置。*/
        public void reaverse(int[] nums,int start,int end){
            while (start<end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        public static void main(String[] args) {
            int[] ints = {1,2,3,4,5,6};
            Q189Three question2two = new Q189Three();
            question2two.rotate(ints,3);
            for (int anInt : ints) {
                System.out.println(anInt);
            }

        }
    }
