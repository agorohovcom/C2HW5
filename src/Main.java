import Exceptions.WrongLoginException;
import Exceptions.WrongPasswordException;

public class Main {

    public static boolean loginAndPasswordValidate(String login, String password, String confirmPassword) {
        boolean isValid = login.matches("[a-zA-Z0-9_]+") &&
                password.matches("[a-zA-Z0-9_]+") &&
                password.length() < 20;

        try {
            loginLengthCheck(login);
            passwordConfirmCheck(password, confirmPassword);
        } catch (WrongLoginException e) {
            e.printStackTrace();
            return false;
        } catch (WrongPasswordException e) {
            e.printStackTrace();
            return false;
        }
        // Можно было объединить в один блок catch "WrongLoginException | WrongPasswordException e",
        // но в условиях задачи сказано "используйте multi-catch block"

        return isValid;
    }

    private static void loginLengthCheck(String login) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException("Длина логина не может быть больше 20");
        }
    }

    private static void passwordConfirmCheck(String password, String confirmPassword) throws WrongPasswordException {
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают, введите заново");
        }
    }

    public static void main(String[] args) {
        System.out.println("Результат проверки: "
                + loginAndPasswordValidate("aaaaaaaaaaaaaaaaaaaa", "aaa1234_5", "aa1234_5"));
    }
}