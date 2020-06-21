import Exceptions.DublicatException;
import Exceptions.FirstArgumentException;
import Exceptions.InputErrorException;
import Exceptions.IsCorrectExpression;

public class Checking {
    boolean check(String inputExpression) {

        if (inputExpression.trim().toLowerCase() == null
                || inputExpression.trim().toLowerCase().trim().length() == 0) {
            try {
                throw new InputErrorException();
            } catch (InputErrorException e) {
                System.out.println("Выражение не может быть пустым");
                return false;
            }
        }

        if (!String.valueOf(inputExpression.charAt(0)).matches("\\d")) {
            try {
                throw new FirstArgumentException();
            } catch (FirstArgumentException e) {
                System.err.println("Первый символ может быть только цифрой!\n");
                System.out.println("");
                return false;
            }
        }
        if (inputExpression.matches(".+(-|\\+|\\*|\\/){2,}.+")) {
            try {
                throw new DublicatException();
            } catch (DublicatException e) {
                System.err.println("Выражение имеет дублирующиеся знаки!\n");
                return false;
            }
        }

        if (!inputExpression.matches("\\d+(\\.|,)*\\d*((\\/|\\+|-|\\*){1}\\d+(\\.|,)*\\d*)*")) {
            try {
                throw new IsCorrectExpression();
            } catch (Exception e) {
                System.err.println("Ошибка в выражании. " +
                        " Не должно быть скобок '()', степени '^'. Разрешается вводить " +
                        "только числа и арифметические знаки\n");
                return false;
            }
        }
        if (inputExpression.matches("\\d+(\\.|,)*\\d*")) {   //если выражение состоит только из 1 числа
            System.out.println(inputExpression);
            return false;
        }
        if (inputExpression.matches(".*\\d+(\\.|\\d)*(\\/)[0].*")) {
            try {
                throw new NullPointerException();
            } catch (NullPointerException exception) {
                System.err.println("Деление на 0");
                return false;
            }

        }
        return true;
    }

}
