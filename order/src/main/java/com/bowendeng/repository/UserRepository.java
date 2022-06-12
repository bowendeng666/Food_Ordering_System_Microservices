package com.bowendeng.repository;

import com.bowendeng.entity.User;

import java.util.List;

public interface UserRepository {

    public User findById(long id);

}
