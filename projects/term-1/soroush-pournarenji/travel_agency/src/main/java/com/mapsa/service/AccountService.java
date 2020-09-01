package com.mapsa.service;

import com.mapsa.dao.AccountDao;
import com.mapsa.model.Account;
import com.mapsa.model.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountDao accountDao;

    public Account getNewAccount() {
        return new Account();
    }

    public void addAccount(Account account) {
        account.setActive("d");
        accountDao.addAccount(account);
    }

    public Account checkLoginAccount(Account account) {
        return accountDao.checkLoginAccount(account);
    }

    public boolean isFindAccountById(long id) {
        if (!accountDao.getAccountById(id).getEmail().isEmpty()) {
            return true;
        }
        return false;
    }

    public Account getAccountById(long id) {
        return accountDao.getAccountById(id);
    }

    public Account getAccountByInformation(Information information) {
        return getAccountById(information.getAccountId());
    }

    public Account editAccount(Account account) {
        accountDao.editAccount(account);
        return account;
    }
}
