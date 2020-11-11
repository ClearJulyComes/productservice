package com.example.productservice.dao;

import com.example.productservice.model.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo, Integer> {
    UserInfo findByUsername(String username);
}
