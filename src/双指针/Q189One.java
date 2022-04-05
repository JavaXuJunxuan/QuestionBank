package 双指针;

/**
 *  189.
 */

public class Q189One {
    public static void rotate(int[] nums, int k) {
        int[] ints = new int[nums.length];
        int a = nums.length;
        for (int i = 0;i< nums.length;i++) {
            if (i + k < a) {
                ints[i+k] = nums[i];
            }else{
//                当k输入过大时会越界
//                ints[i+k-a]=nums[i];
/*                用求余时数组改变后的下标小于原数组长度时会直接输出，等于时输出0，大于时会输出大于的部分，
                比减法好的地方是无论k多大最后求的余数一定会小于属于长度，不会出现越界（整数取模有周期性）*/
                ints[(i + k) % a] = nums[i];
            }
        }
        for (int anInt : ints) {
            System.out.print(anInt+",");
        }
    }
    public static void main(String[] args) {
        int[] ints = {-1};
        rotate(ints,2);
    }
}
