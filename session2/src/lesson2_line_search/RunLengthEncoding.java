package lesson2_line_search;

public class RunLengthEncoding {
    public static void main(String[] args) {
        String income = "AAkAAABBBByBBBCCfCCDDDDDtttttEEEEEvEEFFFFFlllllSSSSSdYYYYYVVVVDJUKKKSSS";
        System.out.println(encode(income));
    }

    static String encode(String income) {
        int lastPos = 0;
        char chr = income.charAt(0);
        StringBuilder builder = new StringBuilder();
        int i = 1;
        for (; i < income.length(); i++) {
            if(chr != income.charAt(i)) {
                builder.append(getChars(chr, i - lastPos));
                lastPos = i;
                chr = income.charAt(i);
            }
        }
        builder.append(getChars(chr, i - lastPos));
        return builder.toString();
    }

    static char[] getChars(char chr, int lastPos) {
        if(lastPos > 1) {
            return new char[]{chr, Character.forDigit(lastPos, 10)};
        } else {
            return new char[]{chr};
        }
    }
}
