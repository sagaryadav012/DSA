package Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle_LC118 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(Arrays.asList(1)));
        if(numRows == 1) return res;
        List<Integer> prev = res.get(0);
        for(int i = 1; i < numRows; i++){
            List<Integer> in = new ArrayList<>(Arrays.asList(1));
            for(int j = 1; j < i; j++){
                in.add(prev.get(j) + prev.get(j-1));
            }
            in.add(1);
            res.add(in);
            prev = in;
        }
        return res;
    }
}
