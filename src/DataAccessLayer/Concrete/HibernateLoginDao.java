package DataAccessLayer.Concrete;

import DataAccessLayer.Abstract.UserDao;
import Entities.Concrete.User;

import java.util.ArrayList;

public class HibernateLoginDao implements UserDao {
    private ArrayList<User> userList = new ArrayList<User>();

    @Override
    public boolean add(User user) {
        if (checkEmail(user)) {
            userList.add(user);
            System.out.println("User with ID: " + user.getId() + " is added.");
            return true;
        }
        else {
            System.out.println("User cannot be added, this email already exists.");
            return false;
        }
    }

    @Override
    public void delete(User user) {
        userList.remove(user);
        System.out.println("User with ID: " + user.getId() + " is deleted.");
    }

    @Override
    public void update(User user) {
        User userToUpdate = getUserByID(user.getId());
        userToUpdate.setName(user.getName());
        System.out.println("User with ID: " + user.getId() + " is updated.");
    }

    @Override
    public boolean checkEmail(User user) {
        for (User person : userList) {
            if (person.getEmail() == user.getEmail()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public User getUserByID(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        return userList;
    }
}
