package com.bowendeng.repository;

import com.bowendeng.entity.Type;

import java.util.List;

public interface TypeRepository {
    public Type findById(long id);
    public List<Type> findAll();
}
