package Trees.LeetCodeMSC;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateBinaryTree_LC2196 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> mp = new HashMap<>();
        Set<Integer> st = new HashSet<>();

        for (int []description: descriptions) {
            int parent = description[0], child = description[1], isLeft = description[2];

            st.add(child);

            TreeNode curr = mp.getOrDefault(parent, new TreeNode(parent));

            if (isLeft == 1) {
                curr.left = mp.getOrDefault(child, new TreeNode(child));
                mp.put(child, curr.left);
            }
            else {
                curr.right = mp.getOrDefault(child, new TreeNode(child));
                mp.put(child, curr.right);
            }

            mp.put(parent, curr);

        }

        for (int []description: descriptions) {
            if (!st.contains(description[0])) {
                return mp.get(description[0]);
            }
        }
        return null;
    }
}
