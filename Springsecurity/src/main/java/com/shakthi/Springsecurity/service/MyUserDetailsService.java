package com.shakthi.Springsecurity.service;

import com.shakthi.Springsecurity.Model.UserPrincipal;
import com.shakthi.Springsecurity.Model.Users;
import com.shakthi.Springsecurity.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUserName(username);
        if(user == null){
            System.out.println("user not found");
            throw  new UsernameNotFoundException("user not found");
        }
        return new UserPrincipal(user);
    }

}
