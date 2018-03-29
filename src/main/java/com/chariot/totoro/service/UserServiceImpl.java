package com.chariot.totoro.service;

import com.chariot.totoro.client.AuthServiceClient;
import com.chariot.totoro.domain.Account;
import com.chariot.totoro.domain.User;
import com.chariot.totoro.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Trung Vu on 2018/03/28.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthServiceClient authServiceClient;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findByUsername(String userName) {
        return accountRepository.findOne(userName);
    }

    @Override
    public Account create(User user) {
        Account existingAccount = accountRepository.findOne(user.getUsername());
        if (existingAccount == null) {
            authServiceClient.createUser(user);
            Account account = new Account();
            account.setUsername(user.getUsername());
            account.setLastSeen(new Date());
            accountRepository.save(account);
            return account;
        }
        return existingAccount;
    }
}
