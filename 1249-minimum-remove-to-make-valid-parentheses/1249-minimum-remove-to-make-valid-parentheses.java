class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int openCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openCount++;
                sb.append(c);
            } else if (c == ')') {
                if (openCount > 0) {
                    openCount--;
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }
        
        // Second pass: remove excess '(' from right to left
        StringBuilder result = new StringBuilder();
        int closeCount = 0;
        
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == ')') {
                closeCount++;
                result.append(c);
            } else if (c == '(') {
                if (closeCount > 0) {
                    closeCount--;
                    result.append(c);
                }
            } else {
                result.append(c);
            }
        }
        
        return result.reverse().toString();
    }
}