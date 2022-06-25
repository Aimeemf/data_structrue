package substringmatch;

class LeetCode1147Solution2 {
    private Long MDD = (long)(1e9 + 7);
    private long[] pow26;

    public int longestDecomposition(String text) {
        pow26 = new long[text.length()];
        pow26[0] = 1;
        for (int i = 1; i < text.length(); i++) {
            pow26[i] = pow26[i - 1] * 26 % MDD;
        }
        return solve(text, 0, text.length() - 1);
    }

    private int solve(String s, int left, int right){
        if(left > right){
            return 0;
        }

        long preHash = 0;
        long postHash = 0;
        for(int i = left, j = right; i < j; i++, j--){
            preHash = (preHash * 26 + (s.charAt(i) - 'a')) % MDD;
            postHash = ((s.charAt(j) - 'a') * pow26[right - j] + postHash) % MDD;
            //s[left, i] == s[j, right]
            if(preHash == postHash && equal(s, left, i, j, right)){
                return 2 + solve(s, i + 1, j - 1);
            }
        }
        return 1;
    }

    private boolean equal(String s, int l1, int r1, int l2, int r2){
        for (int i = l1, j = l2; i <= r1 && j <= r2; i ++, j ++) {
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ghiabcdefhelloadamhelloabcdefghi";
        new LeetCode1147Solution2().longestDecomposition(s);
    }
}