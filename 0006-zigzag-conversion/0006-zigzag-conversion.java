class Solution {
    public String convert(String s, int k) {

        if (k == 1 || s.length() <= k)
            return s;

        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < k; r++) {

            int first = 2 * (k - 1 - r);
            int second = 2 * r;

            int ptr = r;

            sb.append(s.charAt(ptr));

            while (true) {

                // First jump
                if (first != 0) {
                    ptr += first;

                    if (ptr >= s.length())
                        break;

                    sb.append(s.charAt(ptr));
                }

                // Second jump
                if (second != 0) {
                    ptr += second;

                    if (ptr >= s.length())
                        break;

                    sb.append(s.charAt(ptr));
                }
            }
        }

        return sb.toString();
    }
}