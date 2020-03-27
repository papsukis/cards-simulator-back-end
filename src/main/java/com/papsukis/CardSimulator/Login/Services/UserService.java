package com.papsukis.CardSimulator.Login.Services;

import com.papsukis.CardSimulator.Login.Models.User;

public interface UserService {

    User findByName(String name);
    User getUserFromJwt(String jwt);
}
