package GoogleLogin;

import BusinessLayer.Abstract.ILoginService;
import Core.Abstract.ILoginCheckService;
import Core.Abstract.IVerificationService;
import DataAccessLayer.Abstract.UserDao;
import Entities.Concrete.User;

public class GoogleLoginManager implements ILoginService {
    private ILoginCheckService loginCheckService;
    private IVerificationService verificationService;
    private UserDao userDao;

    public GoogleLoginManager(ILoginCheckService loginCheckService, IVerificationService verificationService, UserDao userDao) {
        this.loginCheckService = loginCheckService;
        this.verificationService = verificationService;
        this.userDao = userDao;
    }

    @Override
    public void register(User user) {
        System.out.println("You have registered with Google.");
    }

    @Override
    public void login(User user) {
        System.out.println("You have login with Google.");
    }
}
