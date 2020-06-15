import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operation {
    static int res;
    String sd = null;
    static int promRes;

    static int calculate(char[] chars) {
        Pattern pattern = Pattern.compile("\\d+");
        for (int i = 0; i < chars.length; i++) {
            for (int j = 1; j < chars.length; j++) {


                if (Pattern.matches("[0123456789]+", String.valueOf(chars[i]))) {
                    promRes = chars[i];
                }
                if (Pattern.matches("[+/-/*/]+", String.valueOf(chars[j]))) {
                    switch (chars[j]) {
                        case '+':
                            res = count1 + count2;
                            break;
                        case '-':
                            res = count1 - count2;
                            break;
                        case '*':
                            res = count1 * count2;
                            break;
                        case '/':
                            res = count1 / count2;
                            break;

                }
            }
        }

       /* switch (chars) {
            case '+':
                res = count1 + count2;
                break;
            case '-':
                res = count1 - count2;
                break;
            case '*':
                res = count1 * count2;
                break;
            case '/':
                res = count1 / count2;
                break;
        }*/
        return res;
    }
}
