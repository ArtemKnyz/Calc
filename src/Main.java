import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        Rule rule = new Rule();
        Parsing parsing = new Parsing();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Введите одну из команд - (rule | start | exit): ");
            String params = reader.readLine().trim().toLowerCase();
            if (params.length() < 1) {
                System.out.println("Неверная команда.");
                continue;
            }
            switch (params) {
                case "rule":
                    rule.ruleOfApplication();
                    break;
                case "start":
                    String inputExpression = parsing.inputExpression();
                    if (new Checking().check(inputExpression) == false) {   //проверка валидатором
                        System.out.println("");
                        continue;
                    }
                    System.out.println(new Operation().calculate(parsing.parsingSourceExpression(inputExpression)));
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Неверная команда");
                    break;
            }
        }
    }
}

