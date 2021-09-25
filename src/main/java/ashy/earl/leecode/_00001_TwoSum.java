package ashy.earl.leecode;

import java.util.Arrays;
import java.util.HashMap;

public class _00001_TwoSum implements MyTest {
    @java.lang.Override
    public void test() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] rst = twoSum(nums, target);
        System.out.println("rst: " + Arrays.toString(rst));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> array = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int need = target - num;
            Integer idx = array.get(need);
            if (idx != null) return new int[]{idx, i};
            array.put(num, i);
        }
        return new int[0];
    }
}