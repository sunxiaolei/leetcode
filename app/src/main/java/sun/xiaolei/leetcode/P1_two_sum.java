package sun.xiaolei.leetcode;

import java.util.Arrays;
import java.util.HashMap;

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
        System.out.println(Arrays.toString(twosum1(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twosum2(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twosum3(new int[]{2, 7, 11, 15}, 9)));
    }

    /**
     * 暴力法...遍历每个元素x, 遍历每个元素 x，并查找是否存在一个值与 target - x相等的目标元素。
     * <p>
     * 时间复杂度O(n²)
     * 空间复杂度O(1)
     *
     * @param arr
     * @param target
     * @return
     */
    public static int[] twosum1(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == target - arr[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 两遍哈希表
     * <p>
     * 第一次迭代中，将每个元素的值和它的索引添加到表中。
     * 第二次迭代中，检查每个元素所对应的目标元素（target−nums[i]）是否存在于表中。
     * <p>
     * 时间复杂度：O(n)，把包含有n个元素的列表遍历两次。由于哈希表将查找时间缩短到O(1)，所以时间复杂度为O(n)。
     * 空间复杂度：O(n)，所需的额外空间取决于哈希表中存储的元素数量，该表中存储了n个元素。
     *
     * @param arr
     * @param target
     * @return
     */
    public static int[] twosum2(int[] arr, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            int c = target - arr[i];
            if (hashMap.containsKey(c)) {
                return new int[]{i, hashMap.get(c)};
            }
        }
        return null;
    }

    /**
     * 一遍哈希表
     * <p>
     * 在进行迭代并将元素插入到表中的同时，回过头来检查表中是否已经存在当前元素所对应的目标元素。
     * <p>
     * 时间复杂度：O(n)， 只遍历了包含有n个元素的列表一次。在表中进行的每次查找只花费O(1)的时间。
     * 空间复杂度：O(n)， 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储n个元素。
     *
     * @param arr
     * @param target
     * @return
     */
    public static int[] twosum3(int[] arr, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int c = target - arr[i];
            if (hashMap.containsKey(c)) {
                return new int[]{i, hashMap.get(c)};
            }
            hashMap.put(arr[i], i);
        }
        return null;
    }
}
