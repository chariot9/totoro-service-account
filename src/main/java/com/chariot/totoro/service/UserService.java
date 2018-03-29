package com.chariot.totoro.service;

import com.chariot.totoro.domain.Account;
import com.chariot.totoro.domain.User;

/**
 * Created by Trung Vu on 2018/03/28.
 */
public interface UserService {

    Account findByUsername(String userName);

    Account create(User user);
}
