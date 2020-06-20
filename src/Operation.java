import Exceptions.InputErrorException;

import java.util.Stack;

public class Operation {

    static Double calculate(String parseExpression) throws InputErrorException {
        String expression = "";
        Stack<Double> stack = new Stack<>();
        Parsing p = new Parsing();
        for (int i = 0; i < parseExpression.length(); i++) {
            if (parseExpression.charAt(i) == ' ') {
                continue;
            }
            if (p.getPriorityOfSign(parseExpression.charAt(i)) == 0) {
                while (parseExpression.charAt(i) != ' ' && p
                        .getPriorityOfSign(parseExpression.charAt(i)) == 0) {
                    expression += parseExpression.charAt(i++);
                    if (i == parseExpression.length()) break;
                }
                stack.push(Double.parseDouble(expression));
                expression = new String();
            }
            if (p.getPriorityOfSign(parseExpression.charAt(i)) > 0 ) {
                double a = stack.pop();
                double b = stack.pop();

                if (parseExpression.charAt(i) == '+') {
                    stack.push(a + b);
                }
                if (parseExpression.charAt(i) == '-') {
                    stack.push(b - a);
                }
                if (parseExpression.charAt(i) == '*') {
                    stack.push(a * b);
                }
                if (parseExpression.charAt(i) == '/') {
                    stack.push(b / a);
                }

            }
        }
        return stack.pop();
    }
}