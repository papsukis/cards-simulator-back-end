package com.papsukis.CardSimulator.Login.Services.Implementations;

import com.papsukis.CardSimulator.Login.Models.User;
import com.papsukis.CardSimulator.Login.Repository.UserRepository;
import com.papsukis.CardSimulator.Login.Security.jwt.JwtUtils;
import com.papsukis.CardSimulator.Login.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtUtils jwtUtils;
    @Override
    public User findByName(String name) {
        return userRepository.findByUsername(name).get();
    }
    public User getUserFromJwt(String jwt){
        return findByName(jwtUtils.getUserNameFromJwtToken(jwt.substring(7,jwt.length())));
    }
}
