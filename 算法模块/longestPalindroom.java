class Solution {
    public String longestPalindrome(String s) {
        //  长度为1，返回当前串
    if (s.length()==1){
        return s;
    }
    //长度为2并且两个字符相等则返回
    if (s.length()==2&&s.charAt(0)==s.charAt(1)){
        return s;
    }
        int n = s.length();
        boolean[][] mark = new boolean[n][n];
        int maxLen = 0;
        int beginIndex = 0;
        int lastIndex = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j >= 0) {
                if ((s.charAt(i) == s.charAt(j)) && (i-j < 2 || mark[j+1][i-1])) {
                    mark[j][i] = true;
                     if (maxLen < i-j+1) {
                    beginIndex = j;
                    lastIndex = i+1;
                    maxLen = i-j+1;
                    }
                }
                j--;
            }
        }
        return s.substring(beginIndex, lastIndex);
    }
}