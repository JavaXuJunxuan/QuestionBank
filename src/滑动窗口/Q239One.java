package 滑动窗口;

import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 */

public class Q239One {
    public int[] maxSlidingWindow(int[] nums, int k) {
//        如果当前数组为空，或者元素数小于两个就直接返回数组
        if(nums == null || nums.length < 2) return nums;
//        创建一个队列
//        队列存储元素顺序为从大到小
        LinkedList<Integer> queue = new LinkedList<>();
//        创建一个结果数组用来存储最大值
        int[] result = new int[nums.length - k + 1];
//        遍历nums数组
        for (int i = 0; i < nums.length; i++){
//            只要当前遍历元素大于队尾元素就把队列中所有小于当前元素的所有元素踢出队列
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
//            如果小于队尾就直接加入队列，因为他虽然小于队尾元素，但可能是之后几个元素中的最大值
            queue.addLast(i);
//            如果当前队首元素在正确的左边界前，就把队首元素剔除
            if (queue.peek() < i - k + 1){
                queue.poll();
            }
//            刚开始不会执行这个if因为窗口需要时间才能成型，成型后每次都会执行这个if，即每遍历一次窗口都是新的，都要取出最大值
            if (i + 1 >= k){
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;
    }
}
