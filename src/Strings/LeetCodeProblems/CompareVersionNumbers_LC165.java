package Strings.LeetCodeProblems;

import java.util.Arrays;

public class CompareVersionNumbers_LC165 {
    public static void main(String[] args) {
        String version1 = "1.2";
        String version2 = "1.10";
        System.out.println(compareVersion(version1, version2));
    }
    public static int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int n = split1.length;
        int m = split2.length;
        int i = 0;
        int j = 0;
        while(i < n || j < m){
            int num1 = i >= n ? 0 : Integer.parseInt(split1[i]);
            int num2 = j >= m ? 0 :Integer.parseInt(split2[j]);
            if(num1 < num2) return -1;
            if(num1 > num2) return 1;
            i++;j++;
        }
//        System.out.println(Arrays.toString(split1));
        return 0;
    }
}
