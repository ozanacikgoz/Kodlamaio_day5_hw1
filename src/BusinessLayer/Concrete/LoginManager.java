package BusinessLayer.Concrete;

import BusinessLayer.Abstract.ILoginService;
import Core.Abstract.ILoginCheckService;
import Core.Abstract.IVerificationService;
import DataAccessLayer.Abstract.UserDao;
import Entities.Concrete.User;

import java.util.Scanner;

public class LoginManager implements ILoginService {
    private ILoginCheckService loginCheckService;
    private IVerificationService verificationService;
    private UserDao userDao;

    public LoginManager(ILoginCheckService loginCheckService, IVerificationService verificationService, UserDao userDao) {
        this.loginCheckService = loginCheckService;
        this.verificationService = verificationService;
        this.userDao = userDao;
    }

    @Override
    public void register(User user) {
        if (loginCheckService.checkUser(user)) {
            if (userDao.add(user)) {
                verificationService.sendVerificationEmail(user);
                verificationService.clickVerificationButton(user);
                System.out.println("User registration completed successfully.");
            }
            else {
                System.out.println("User registration is failed.");
                return;
            }

        }
        else {
            System.out.println("User registration is failed.");
        }
    }

    @Override
    public void login(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the email to login: ");
        String email = scanner.nextLine();
        System.out.println("Enter the password to login: ");
        String password = scanner.nextLine();

        if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
            System.out.println("Login is successful.");
            return;
        }
        System.out.println("Login is not successful.");
    }
}
