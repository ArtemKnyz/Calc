import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        //System.out.println("test");
        Rule rule = new Rule();
        Parsing parsing = new Parsing();

        String text = "2+4*16/2.5+3,5";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Введите одну из команд - (rule | start | exit): ");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");
            if (params.length < 1) {
                System.out.println("Неверная команда.");
                continue;
            }
            switch (params[0]) {
                case "rule":
                    rule.ruleOfApplication();
                    break;
                case "start":
                    parsing.pars(text);
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

