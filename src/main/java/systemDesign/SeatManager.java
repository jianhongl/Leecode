/**
 * FileName: Leetcode1845
 * Author:   Jianhongl
 * Date:     17/2/2022 10:26 pm
 * Description:
 * History:
 */
package systemDesign;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lujianhong
 * @create 17/2/2022
 * @since 1.0.0
 */
public class SeatManager {
    private final PriorityQueue<Integer> seatsChoice;

    public SeatManager(int n) {
        seatsChoice = new PriorityQueue<>(n);
        for (int i = 0; i < n; i++) {
            seatsChoice.offer(i + 1);
        }
    }

    public int reserve() {
        return seatsChoice.poll();
    }

    public void unreserve(int seatNumber) {
        seatsChoice.add(seatNumber);
    }
}
