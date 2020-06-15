import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Parsing {
    String inputExpression() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите выражение: ");
        String inputText = reader.readLine().trim().toLowerCase();

        return inputText.toString();
    }

    char[] pars(String message) {
        char[] charsInput = message.toCharArray();
        System.out.println(Arrays.toString(charsInput));
        return charsInput;
    }

}
