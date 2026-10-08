import java.util.*;

class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] S = stamp.toCharArray();
        char[] T = target.toCharArray();
        int m = S.length;
        int n = T.length;
        
        boolean[] visited = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        // Check which windows match initially
        for (int i = 0; i <= n - m; i++) {
            if (canStamp(T, i, S)) {
                queue.offer(i);
                visited[i] = true;
            }
        }
        
        int stars = 0;
        
        while (!queue.isEmpty()) {
            int i = queue.poll();
            ans.add(i);
            for (int j = 0; j < m; j++) {
                if (T[i + j] != '?') {
                    T[i + j] = '?';
                    stars++;
                    // Check all windows overlapping with this newly revealed '?'
                    for (int k = Math.max(0, i + j - m + 1); k <= Math.min(n - m, i + j); k++) {
                        if (!visited[k] && canStamp(T, k, S)) {
                            visited[k] = true;
                            queue.offer(k);
                        }
                    }
                }
            }
        }
        
        if (stars != n) {
            return new int[0];
        }
        
        // Reverse because we worked backwards from target to '?'
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(ans.size() - 1 - i);
        }
        
        return result;
    }
    
    private boolean canStamp(char[] T, int i, char[] S) {
        boolean hasChar = false;
        for (int j = 0; j < S.length; j++) {
            if (T[i + j] == '?') continue;
            if (T[i + j] != S[j]) return false;
            hasChar = true;
        }
        return hasChar;
    }
}