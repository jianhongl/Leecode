package systemDesign;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lujianhong
 * @create 15/12/21
 * @since 1.0.0
 */
public class FileSystem {
    private Map<String, Integer> files;

    public FileSystem() {
        files = new HashMap<>();

        files.put("", -1);
    }

    public boolean createPath(String path, int value) {
        if (files.containsKey(path)) {
            return false;
        }

        int last = path.lastIndexOf("/");
        String prevRoot = path.substring(0, last);
        if (!files.containsKey(prevRoot)) {
            return false;
        }

        files.put(path, value);
        return true;
    }

    public int get(String path) {
        return files.getOrDefault(path, -1);
    }
}
