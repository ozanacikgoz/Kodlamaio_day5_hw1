import BusinessLayer.Abstract.ILoginService;
import BusinessLayer.Concrete.LoginManager;
import Core.Concrete.LoginCheckManager;
import Core.Concrete.VerificationManager;
import DataAccessLayer.Concrete.HibernateLoginDao;
import Entities.Concrete.User;
import GoogleLogin.GoogleLoginManager;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(100,"Ozan", "Açıkgöz", "ackgozozan@gmail.com", "testp");
        User user2 = new User(101,"Eren", "Şentürk", "rocanseker@gmail.com", "testpw");
        User user3 = new User(102,"Rohat", "Şeker", "rocanseker@gmail.com", "testpw");

        ILoginService loginService = new LoginManager(new LoginCheckManager(), new VerificationManager(), new HibernateLoginDao());
        ILoginService googleLoginService = new GoogleLoginManager(new LoginCheckManager(), new VerificationManager(), new HibernateLoginDao());

        loginService.register(user1);
        System.out.println("-----------------------------------------------");
        loginService.register(user2);
        System.out.println("-----------------------------------------------");
        loginService.register(user3);
        System.out.println("-----------------------------------------------");
        googleLoginService.register(user3);
        System.out.println("-----------------------------------------------");
        googleLoginService.login(user3);

    }
}
