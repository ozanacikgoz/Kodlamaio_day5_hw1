package Core.Concrete;

import Core.Abstract.IVerificationService;
import Entities.Concrete.User;

public class VerificationManager implements IVerificationService {
    @Override
    public void sendVerificationEmail(User user) {
        System.out.println("Verification email has send.");
    }

    @Override
    public void clickVerificationButton(User user) {
        System.out.println("Registration is verified.");
    }
}
