package Trees.LeetCodeMSC;

public class StepByStepFromBTNodeToAnother_LC2096 {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        findPath(root, startValue, pathToStart);
        findPath(root, destValue, pathToDest);

        int n = pathToStart.length();
        int m = pathToDest.length();

        int i = 0;
        while(i < n && i < m && pathToStart.charAt(i) == pathToDest.charAt(i)){
            i++;
        }

        int stepsUp = n - i;
        StringBuilder result = new StringBuilder();

        while(stepsUp > 0){
            result.append("U");
            stepsUp--;
        }

        result.append(pathToDest.toString().substring(i));

        return result.toString();
    }
    private boolean findPath(TreeNode root, int value, StringBuilder path) {
        if (root == null) {
            return false;
        }
        if (root.val == value) {
            return true;
        }
        path.append('L');
        if (findPath(root.left, value, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if (findPath(root.right, value, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        return false;
    }
}
