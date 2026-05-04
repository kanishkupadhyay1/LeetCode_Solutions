class Solution {
    public int strongPasswordChecker(String s) {
        int n = s.length();
        
        int hasLower = 0, hasUpper = 0, hasDigit = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = 1;
            else if (Character.isUpperCase(c)) hasUpper = 1;
            else if (Character.isDigit(c)) hasDigit = 1;
        }
        
        int missingTypes = 3 - (hasLower + hasUpper + hasDigit);
        
        int replace = 0;
        int[] arr = new int[n];
        
        for (int i = 0; i < n;) {
            int j = i;
            while (i < n && s.charAt(i) == s.charAt(j)) i++;
            arr[j] = i - j;
        }
        
        if (n < 6) {
            return Math.max(missingTypes, 6 - n);
        }
        
        if (n <= 20) {
            for (int len : arr) {
                replace += len / 3;
            }
            return Math.max(missingTypes, replace);
        }
        
        int delete = n - 20;
        int remainingDelete = delete;
        
        for (int k = 0; k < n && remainingDelete > 0; k++) {
            if (arr[k] >= 3 && arr[k] % 3 == 0) {
                arr[k]--;
                remainingDelete--;
            }
        }
        
        for (int k = 0; k < n && remainingDelete > 0; k++) {
            if (arr[k] >= 3 && arr[k] % 3 == 1) {
                int need = Math.min(2, remainingDelete);
                arr[k] -= need;
                remainingDelete -= need;
            }
        }
        
        for (int k = 0; k < n && remainingDelete > 0; k++) {
            if (arr[k] >= 3) {
                int need = Math.min(arr[k] - 2, remainingDelete);
                arr[k] -= need;
                remainingDelete -= need;
            }
        }
        
        for (int len : arr) {
            if (len >= 3) {
                replace += len / 3;
            }
        }
        
        return delete + Math.max(missingTypes, replace);
    }
}