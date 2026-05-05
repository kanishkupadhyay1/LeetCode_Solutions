import java.util.*;

class Solution {
    Set<Integer> s = new HashSet<>();

    public int findSecondMinimumValue(TreeNode root) {
        inorder(root);

        if (s.size() < 2) return -1;

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int val : s) {
            if (val < min) {
                secondMin = min;
                min = val;
            } else if (val > min && val < secondMin) {
                secondMin = val;
            }
        }

        return secondMin;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            s.add(root.val);
            inorder(root.right);
        }
    }
}