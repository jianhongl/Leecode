package binarySearch; /**
 * FileName: binarySearch.TimeMap
 * Author:   Jianhongl
 * Date:     7/2/2022 11:15 pm
 * Description:
 * History:
 */

import java.util.*;

/**
 * @author lujianhong
 * @create 7/2/2022
 * @since 1.0.0
 */
public class TimeMap {
    class Node {
        private String key;
        private String value;
        private int timestamp;
        public Node(String key, String value, int timestamp) {
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private Map<String, List<Node>> timeMap = null;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Node> nodeList = timeMap.getOrDefault(key, new ArrayList<>());
        nodeList.add(new Node(key, value, timestamp));
        timeMap.put(key, nodeList);
    }

    public String get(String key, int timestamp) {
        List<Node> nodeList = timeMap.getOrDefault(key, new ArrayList<>());
        if (nodeList.size() == 0) {
            return "";
        }
        int size = nodeList.size();
        int left = 0;
        int right = size - 1;
        while (left < right) {
            int mid = right - (right - left) / 2;
            if (nodeList.get(mid).timestamp <= timestamp) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return nodeList.get(left).timestamp <= timestamp ? nodeList.get(right).value : "";
    }
}
