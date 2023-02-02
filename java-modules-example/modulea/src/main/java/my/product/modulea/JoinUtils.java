package my.product.modulea;

import java.util.List;

class JoinUtils {
    public static String join(List<String> source) {
        StringBuilder result = new StringBuilder();
        for (String s : source) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(s);
        }

        return result.toString();
    }
}
