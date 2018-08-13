package com.anjie.blogserver.controller;

import com.anjie.blogserver.domain.RespBean;
import com.anjie.blogserver.service.UserService;
import com.anjie.blogserver.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sang on 2017/12/24.
 */
@RestController
public class TestController {


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public RespBean updateUserEmail() {

        return new RespBean("error", "开启失败!");
    }
}
