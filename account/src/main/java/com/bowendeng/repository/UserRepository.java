package com.bowendeng.repository;

import com.bowendeng.entity.User;

public interface UserRepository {
    public User login(String username, String password);
}
