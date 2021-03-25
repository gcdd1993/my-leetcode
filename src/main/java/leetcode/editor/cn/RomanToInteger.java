package leetcode.editor.cn;

public class RomanToInteger {
    public static void main(String[] args) {
        Solution solution = new RomanToInteger().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int romanToInt(String s) {
            int n = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                switch (c) {
                    case 'I': {
                        if (i + 1 < s.length()) {
                            char next = s.charAt(i + 1);
                            if (next == 'V') {
                                n += 4;
                                i++;
                            } else if (next == 'X') {
                                n += 9;
                                i++;
                            } else {
                                n += 1;
                            }
                        } else {
                            n += 1;
                        }
                    }
                    break;
                    case 'V':
                        n += 5;
                        break;
                    case 'X': {
                        if (i + 1 < s.length()) {
                            char next = s.charAt(i + 1);
                            if (next == 'L') {
                                n += 40;
                                i++;
                            } else if (next == 'C') {
                                n += 90;
                                i++;
                            } else {
                                n += 10;
                            }
                        } else {
                            n += 10;
                        }
                    }
                    break;
                    case 'L':
                        n += 50;
                        break;
                    case 'C': {
                        if (i + 1 < s.length()) {
                            char next = s.charAt(i + 1);
                            if (next == 'D') {
                                n += 400;
                                i++;
                            } else if (next == 'M') {
                                n += 900;
                                i++;
                            } else {
                                n += 100;
                            }
                        } else {
                            n += 100;
                        }
                    }
                    break;
                    case 'D':
                        n += 500;
                        break;
                    case 'M':
                        n += 1000;
                        break;
                }
            }
            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}