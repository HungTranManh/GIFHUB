package com.t3h.demospring;

import com.t3h.demospring.model.database.*;
import com.t3h.demospring.model.request.UserLogin;
import com.t3h.demospring.model.request.UserRegister;
import com.t3h.demospring.model.response.BaseResponse;
import com.t3h.demospring.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.t3h.demospring.model.database.UserProfile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lap trinh on 5/18/2018.
 */
@RestController
public class UserController {
    @Autowired
    private UserProfileRepository userProfileRepository;
    @PostMapping("/api/register")
    public Object register(
          @RequestBody UserRegister userRegister
    ){
        UserProfile user = userProfileRepository.findOneUsername(userRegister.getUsername());
        if (user != null ) {
            return new BaseResponse(BaseResponse.ERROR_PARAM, "User exist");
        }
        user = new UserProfile();
        user.setUsername(userRegister.getUsername());
        user.setPassword(userRegister.getPassword());
        user.setAge(userRegister.getAge());
        user.setFirstName(userRegister.getFirstName());
        user.setLastName(userRegister.getLastName());
        user.setGender(true);
        user.setAvatar(userRegister.getAvatar());
        return new BaseResponse(userProfileRepository.save(user));
    }

    @GetMapping("/api/getAll")
    public Object getAll(){
        return null;
    }

    @PostMapping("/api/login")
    public Object login(
            @RequestBody UserLogin userLogin
    ){
       return null;
    }
}
