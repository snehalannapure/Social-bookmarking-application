package com.dao;

import com.entities.User;
import com.thrillio.DataStore;

public class UserDao {
    public User[] getUsers(){
        return DataStore.getUsers();
    }
}
