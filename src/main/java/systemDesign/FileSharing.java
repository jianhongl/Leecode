package systemDesign;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lujianhong
 * @create 15/2/2022
 * @since 1.0.0
 * @description: LeetCode 1500 design a file sharing system
 */
public class FileSharing {
    private Set<Integer> releaseUsers;

    private HashMap<Integer, List<Integer>> chunksMap;

    private HashMap<Integer, List<Integer>> usersMap;

    private int id;

    public FileSharing(int m) {
        id = 1;
        chunksMap = new HashMap<>();
        releaseUsers = new HashSet<>();
        for (int i = 1; i <= m; i++) {
            chunksMap.put(i, new ArrayList<>());
        }
    }

    public int join(List<Integer> ownedChunks) {
        int joinId = 0;
        if (releaseUsers.size() > 0) {
            joinId = Collections.min(releaseUsers);
            releaseUsers.remove(joinId);
        } else {
            joinId = id++;
        }

        for (int i = 0; i < ownedChunks.size(); i++) {
            List<Integer> userList = chunksMap.getOrDefault(ownedChunks.get(i), new ArrayList<>());
            userList.add(joinId);
            chunksMap.put(ownedChunks.get(i), userList);
        }

        usersMap.put(joinId, ownedChunks);

        return joinId;
    }

    public void leave(int userID) {
        releaseUsers.add(userID);
        List<Integer> chunksList = usersMap.get(userID);
        for (int i = 0; i < chunksList.size(); i++) {
            chunksMap.put(chunksList.get(i), chunksMap.get(i).stream().filter(chunkID -> chunkID != userID).collect(Collectors.toList()));
        }
    }

    public List<Integer> request(int userID, int chunkID) {
        List<Integer> userList = chunksMap.getOrDefault(chunkID, new ArrayList<>());
        Collections.sort(userList);
        return userList;
    }
}
