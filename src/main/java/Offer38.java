/**
 * FileName: Offer38
 * Author:   Jianhongl
 * Date:     11/1/22 11:02 pm
 * Description:
 * History:
 */

import java.util.*;

/**
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 *
 * @author lujianhong
 * @create 11/1/22
 * @since 1.0.0
 */
public class Offer38 {
    private int len;
    public String[] permutation(String s) {
        len = s.length();
        Set<String> temp = new HashSet<String>();
        StringBuilder path = new StringBuilder();
        boolean[] visited = new boolean[len];
        dfs(s, path, temp, visited);
        String[] res = new String[temp.size()];
        int i = 0;
        for (String elem : temp) {
            res[i++] = elem;
        }
        return res;
    }

    private void dfs(String s, StringBuilder path, Set<String> temp, boolean[] visited) {
        if (path.length() == len && !temp.contains(String.valueOf(path))) {
            temp.add(String.valueOf(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                path.append(s.charAt(i));
                visited[i] = true;
                dfs(s, path, temp, visited);
                visited[i] = false;
                path.deleteCharAt(path.length() - 1);
            }

        }
    }

    public static void main(String[] args) {
        Offer38 offer38 = new Offer38();
        System.out.println(Arrays.toString(offer38.permutation("abc")));
    }
}
