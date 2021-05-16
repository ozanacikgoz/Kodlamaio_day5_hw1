package DataAccessLayer.Abstract;

import Entities.Concrete.User;

import java.util.ArrayList;

public interface UserDao {
    boolean add(User user);
    void delete(User user);
    void update(User user);
    boolean checkEmail(User user);
    User getUserByID(int id);
    ArrayList<User> getAllUsers();
}
