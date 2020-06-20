import Exceptions.InputErrorException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Parsing {
    String inputExpression() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите выражение: ");
        return reader.readLine().trim().toLowerCase();
    }

    String parsingSourceExpression(String sourceExpression) throws InputErrorException {
        Stack<Character> sign = new Stack<>();
        String outExpression = "";
        int priorityOfSign = 0;
        for (int i = 0; i < sourceExpression.length(); i++) {
            priorityOfSign = getPriorityOfSign(sourceExpression.charAt(i));

            //check isDigit
            if (priorityOfSign == 0) {
                outExpression += sourceExpression.charAt(i);
            }
            if (priorityOfSign > 0) {
                outExpression += " ";
                while (!sign.empty()) {
                    if (getPriorityOfSign(sign.peek()) == 2) {
                        outExpression += sign.pop();
                    } else break;
                }
                sign.push(sourceExpression.charAt(i));
            }
        }
        while (!sign.empty()) {
            outExpression += sign.pop();
        }
        return outExpression;
    }

    public int getPriorityOfSign(char ch) throws InputErrorException {
        if (ch == '+' || ch == '-') {
            return 1;
        }
        if (ch == '*' || ch == '/') {
            return 2;
        }
        return 0;
    }
}
