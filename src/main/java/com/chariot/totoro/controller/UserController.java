package com.chariot.totoro.controller;

import com.chariot.totoro.domain.Account;
import com.chariot.totoro.domain.User;
import com.chariot.totoro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by Trung Vu on 2018/03/28.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("#oauth2.hasScope('server') or #name.equals('demo')")
    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public Account getAccountByName(@PathVariable String name) {
        return userService.findByUsername(name);
    }

    @RequestMapping(path = "/current", method = RequestMethod.GET)
    public Account getCurrentAccount(Principal principal) {
        return userService.findByUsername(principal.getName());
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public Account createNewAccount(@Valid @RequestBody User user) {
        System.out.println("Log for user information:" + user.getUsername() + user.getPassword());
        return userService.create(user);
    }
}
