package BusinessLayer.Abstract;

import Entities.Concrete.User;

public interface ILoginService {
    void register(User user);
    void login(User user);
}
