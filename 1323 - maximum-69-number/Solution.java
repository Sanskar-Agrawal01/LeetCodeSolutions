class Solution {
    public int maximum69Number(int num) {
        String s = String.valueOf(num);
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 6) {
                arr[i] = 9;
                break;
            }
        }
        int num2 = 0;
        for (int digit : arr) {
            num2 = num2 * 10 + digit;
        }

        return num2;

    }
}