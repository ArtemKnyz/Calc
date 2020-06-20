import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class Operation {

    static Double calculate(String chars) {
        String st = "";
        Stack<Double> sr = new Stack<>();
        Parsing p = new Parsing();
        for (int i = 0; i < chars.length(); i++) {
            if (chars.charAt(i) == ' ') {
                continue;
            }
            if (p.getPriority(chars.charAt(i)) == 0) {
                while (chars.charAt(i) != ' ' && p.getPriority(chars.charAt(i)) == 0) {
                    st += chars.charAt(i++);
                    if (i == chars.length()) break;
                }
                sr.push(Double.parseDouble(st));
                st = new String();
            }
            if (p.getPriority(chars.charAt(i)) > 0) {
                double a = sr.pop(), b = sr.pop();

                if (chars.charAt(i) == '+') {
                    sr.push(a + b);
                }
                if (chars.charAt(i) == '-') {
                    sr.push(b - a);
                }
                if (chars.charAt(i) == '*') {
                    sr.push(a * b);
                }
                if (chars.charAt(i) == '/') {
                    sr.push(b / a);
                }

            }
        }
        return sr.pop();
    }
}
