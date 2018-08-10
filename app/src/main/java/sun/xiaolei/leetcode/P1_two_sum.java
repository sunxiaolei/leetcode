package sun.xiaolei.leetcode;

import java.util.Arrays;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:两数之和
 * <p>
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class P1_two_sum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twosum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twosum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
