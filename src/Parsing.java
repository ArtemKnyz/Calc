import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Parsing {
    String inputExpression() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите выражение: ");
        return reader.readLine().trim().toLowerCase();
    }

    String par(String sourceText) {
        Stack<Character> sign = new Stack<>();
        String ds = "";
        int priority = 0;
        for (int i = 0; i < sourceText.length(); i++) {
            priority = getPriority(sourceText.charAt(i));
            if (priority == 0) {
                ds += sourceText.charAt(i);
            }
            if (priority == 1) {
                ds += " ";
                while (!sign.empty()){
                    if(getPriority(sign.peek())==2){
                        ds+=sign.pop();
                    } else break;
                }
                sign.push(sourceText.charAt(i));
            }
            if (priority == 2) {
                ds += " ";
                while (!sign.empty()) {
                    if (getPriority(sign.peek()) == 2) {
                        ds += sign.pop();
                    } else break;
                }
                sign.push(sourceText.charAt(i));
            }
        }
        while (!sign.empty()) {
            ds += sign.pop();
        }
        return ds;
    }

    public int getPriority(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        }
        if (ch == '*' || ch == '/') {
            return 2;
        }
        return 0;
    }
}
