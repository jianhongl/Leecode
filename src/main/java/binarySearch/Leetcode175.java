/**
 * FileName: Leetcode175
 * Author:   Jianhongl
 * Date:     8/2/2022 9:20 pm
 * Description:
 * History:
 */
package binarySearch;

import java.util.Arrays;

/**
 * @author lujianhong
 * @create 8/2/2022
 * @since 1.0.0
 */
public class Leetcode175 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int left = 0;
        int right = (int)1e9;
        while (left < right) {
            int mid = right - (right - left + 1) / 2;
            if (check(houses, heaters, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean check(int[] houses, int[] heaters, int x) {
        int n = houses.length;
        int m = heaters.length;
        for (int i = 0, j = 0; i < n; i++) {
            // 找出当前房屋在给定半径下可覆盖到的加热器
            while (j < m && houses[i] > heaters[j] + x) {
                j++;
            }

            // 确认当前加热器的下限是否能覆盖到房屋，如果是就以当前加热器的位置去继续判断下一个房子，因为房子和加热器的位置都是递增的，
            // 如果有加热器的下限无法囊括该房子，那么更远的加热器更加无法覆盖，所以直接return false
            if (j < m && heaters[j] - x <= houses[i]) {
                continue;
            }
            return false;
        }
        return true;
    }
}
