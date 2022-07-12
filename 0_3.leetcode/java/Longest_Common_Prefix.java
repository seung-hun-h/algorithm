public class Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        return find(strs);
    }

    private String find(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int len = strs[0].length();
        for (int i=0;i<len;i++) {
            char prefix = strs[0].charAt(i);
            for (int j=1;j<strs.length;j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != prefix) return sb.toString();
            }

            sb.append(prefix);
        }

        return sb.toString();
    }
}
