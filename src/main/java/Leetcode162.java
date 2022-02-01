/**
 * FileName: Leetcode162
 * Author:   Jianhongl
 * Date:     12/1/22 10:41 pm
 * Description:
 * History:
 */

/**
 * 162. 寻找峰值
 * @author lujianhong
 * @create 12/1/22
 * @since 1.0.0
 */
public class Leetcode162 {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Leetcode162 test = new Leetcode162();
        int[] nums = {1,2,3,1};
        System.out.println(test.findPeakElement(nums));
    }
}
