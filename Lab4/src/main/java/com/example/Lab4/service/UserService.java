package com.example.Lab4.service;

import com.example.Lab4.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    List<User> list = new ArrayList<>();

    public UserService(){
        list.add( new User("NV1", "123", "nhanvien1@gmail.com", "Bùi Minh Hiếu", true));
        list.add( new User("NV2", "234", "nhanvien2@gmail.com", "Phan Quang Hảo", false));
        list.add( new User("NV3", "345", "nhanvien3@gmail.com", "Trần Thị Ánh Quỳnh", true));
        list.add( new User("NV4", "456", "nhanvien4@gmail.com", "Hoàng Văn Thảnh", false));
        list.add( new User("NV5", "678", "nhanvien5@gmail.com", "Phạm Thị Lan Anh", true));

    }

    public List<User> fillAll() {
        return list;
    }

    public void addUser(User user){
        list.add(user);
    }

    public void updateUser (int index, User user){
        list.set(index, user);
    }

    public User getUser (int index){
        return list.get(index);
    }

    public void deleteUser (int index){
        list.remove(index);
    }
}
