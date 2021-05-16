package Core.Abstract;

import Entities.Concrete.User;

public interface ILoginCheckService {
    boolean checkUser(User user);
}
