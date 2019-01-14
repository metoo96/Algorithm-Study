class Solution {
    
    public List<String> letterCasePermutation(String S) {
       List<String> res = new LinkedList<>();
       dfs("", S, res, 0);
       return res;
    }
    
    public void dfs(String pre, String S, List<String> res, int index) {
        if (index == S.length()) {
            res.add(pre);
        } else {
            char ch = S.charAt(index);
            if (!Character.isLetter(ch)) {
                dfs(pre + ch, S, res, index+1);
            } else {
                ch = Character.toLowerCase(ch);
                dfs(pre+ch, S, res, index+1);
                ch = Character.toUpperCase(ch);
                dfs(pre+ch, S, res, index+1);
            }
        }
    }
    
}