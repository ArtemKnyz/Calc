import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Rule rule = new Rule();
        Parsing parsing = new Parsing();

        //String text = "2+4*16/2.5+3,5";
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
                    String s = parsing.inputExpression();
                    System.out.println("Вы ввели: " + s.toString());
                    parsing.pars(s);

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

