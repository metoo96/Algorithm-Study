class Solution {
    
    public boolean isPalindrome(int x) {
        int x1 = x;
        int temp = 0;
        while (x > 0) {
            temp = temp * 10 + x%10;
            x = x / 10;
        }
        if (temp == x1) {
            return true;
        } else {
            return false;
        }
    }
    
}