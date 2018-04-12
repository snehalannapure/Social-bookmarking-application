package com.managers;
import com.dao.UserDao;
import com.entities.User;


public class UserManager {
    private static UserManager instance = new UserManager();
    private static UserDao dao  = new UserDao();

    private UserManager() {}

    public static UserManager getInstance() {
        return instance;
    }

    public User createUser(long id, String value, String email, String password, String name, int gender, String userType){
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setGender(gender);
        user.setUserType(userType);

        return user;
    }

    public User[] getUsers(){
        return dao.getUsers();
    }
}
