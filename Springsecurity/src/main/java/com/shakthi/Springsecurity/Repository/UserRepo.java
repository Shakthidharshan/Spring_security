package com.shakthi.Springsecurity.Repository;

import com.shakthi.Springsecurity.Model.Users;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.PrivateKey;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {

    public Users findByUserName(String username);

}
