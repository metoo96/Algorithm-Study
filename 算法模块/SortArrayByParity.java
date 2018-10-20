class Solution {
    
    public int[] sortArrayByParity(int[] A) {
        for (int i = 0; i < A.length-1; i++) {
            for (int j = 0; j < A.length-1-i; j++) {
                if (A[j+1] % 2 == 0 && A[j] % 2 != 0) {
                    int temp = A[j+1];
                    A[j+1] = A[j];
                    A[j] = temp;
                }
            }
        }
        return A;
    }
    
}