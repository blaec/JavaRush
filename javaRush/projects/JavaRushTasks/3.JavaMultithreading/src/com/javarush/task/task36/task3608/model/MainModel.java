package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class MainModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
//        List<User> users = new ArrayList<>();
//        users.add(new User("A", 1, 1));
//        users.add(new User("B", 2, 1));

        modelData.setUsers(userService.getUsersBetweenLevels(1, 100));
    }
}
