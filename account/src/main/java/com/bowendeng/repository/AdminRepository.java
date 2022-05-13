package com.bowendeng.repository;

import com.bowendeng.entity.Admin;

public interface AdminRepository {
    public Admin login(String username, String password);

}
