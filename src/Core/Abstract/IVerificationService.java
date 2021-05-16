package Core.Abstract;

import Entities.Concrete.User;

public interface IVerificationService {
    void sendVerificationEmail(User user);
    void clickVerificationButton(User user);
}
