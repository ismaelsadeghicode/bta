package com.mapsa.dao;

import com.mapsa.model.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAllAccount();
    Account getAccountById(long id);
    void addAccount(Account account);
    void editAccount(Account account);
    Account checkLoginAccount(Account account);
     boolean isFindAccountById(long id);
}
