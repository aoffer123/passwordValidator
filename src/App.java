import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String args[]) {
        
        System.out.println("Please input your password: ");

        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        sc.close();
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$";
        boolean validPassword = isValidPassword(password, regex);
        System.out.println("It's valid password: \n" + validPassword);

        
        if (password.length() > 16 || password.length() < 8) {
            System.out.println("Password must be less than 16 and more than 8.");
            
        }

        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars)) {
            System.out.println("Password much contain at least one upper case character i.e A-Z.");
            
        }

        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars)) {
            System.out.println("Password must have at least one lower case character i.e a-z.");
            
        }

        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers)) {
            System.out.println("Password must have at least one number i.e 0-9");
        }

        String specialChars = "(.*[~!@#$%^&*()-=+_].*$)";
        if (!password.matches(specialChars)) {
            System.out.println("Password must contain one these special characters: ~!@#$%^&*()-=+_");
        }
    }
        
        


    public static boolean isValidPassword(String password, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}