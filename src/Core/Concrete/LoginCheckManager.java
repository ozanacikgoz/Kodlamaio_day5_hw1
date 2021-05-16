package Core.Concrete;

import Core.Abstract.ILoginCheckService;
import Entities.Concrete.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginCheckManager implements ILoginCheckService {

    public static final String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

    @Override
    public boolean checkUser(User user) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user.getEmail());

        if (user.getName().length() < 3) {
            System.out.println("Name is invalid, please enter a name greater than 2 characters.");
            return false;
        }
        else if (user.getSurname().length() < 3) {
            System.out.println("Name is invalid, please enter a name greater than 2 characters.");
            return false;
        }
        else if (user.getPassword().length() < 6) {
            System.out.println("Your password should contain at least 6 characters ");
            return false;
        }
        else if (!matcher.matches()) {
            System.err.println("Your email type should contain @gmail.com ");
            return false;
        }
        return true;
    }
}
