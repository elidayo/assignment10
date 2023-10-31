import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Password {
    public static boolean validatePassword(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        int categoryCount = 0;

        if (Pattern.compile("[a-z]").matcher(password).find()) {
            categoryCount++;
        }

        if (Pattern.compile("[A-Z]").matcher(password).find()) {
            categoryCount++;
        }

        if (Pattern.compile("[0-9]").matcher(password).find()) {
            categoryCount++;
        }

        if (Pattern.compile("[~!@#\\$%^&*\\(\\)-=_\\+]").matcher(password).find()) {
            categoryCount++;
        }

        return categoryCount >= 3;
    }

    public static void main(String[] args) {
        String password = "P@ssw0rd";
        if (validatePassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
    }
}
