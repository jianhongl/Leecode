/**
 * FileName: Leetcode1268
 * Author:   Jianhongl
 * Date:     16/2/2022 11:53 pm
 * Description:
 * History:
 */
package systemDesign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lujianhong
 * @create 16/2/2022
 * @since 1.0.0
 */
public class Leetcode1268 {
    private List<String> prefix = new ArrayList<>();
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        int len = searchWord.length();
        List<List<String>> result = new ArrayList<>(len);

        for (int i = 0; i < len; i++) {
            result.add(new ArrayList<>());
            prefix.add(searchWord.substring(0, i + 1));
        }

        for (int j = 0; j < products.length; j++) {
            for (int p = 0; p < prefix.size(); p++) {
                if (products[j].startsWith(prefix.get(p))) {
                    result.get(p).add(products[j]);
                }
            }
        }

        result.forEach(exceedList -> {
            Collections.sort(exceedList);
            while (exceedList.size() > 3) {
                exceedList.remove(exceedList.size() - 1);
            }
        });

        return result;
    }
}
