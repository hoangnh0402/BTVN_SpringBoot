package com.example.btvn_week3.model;
import java.util.ArrayList;
import java.util.List;
public class Store {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("nguyenvana","123456","Nguyen Van A" ));
        users.add(new User("nguyenvanb","123456","Nguyen Van B" ));
        users.add(new User("nguyenvanc","123456","Nguyen Van C" ));
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        Store.users = users;
    }
}
