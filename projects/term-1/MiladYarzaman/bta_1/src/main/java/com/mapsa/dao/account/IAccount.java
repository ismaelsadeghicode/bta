package com.mapsa.dao.account;

import com.mapsa.models.Account;
import com.mapsa.services.account.CustomExeption;

import java.util.List;

public interface IAccount {

    long createAccount(Account account) throws CustomExeption;
    List<Account> getAccountList();
    Account getAccountById(long accountId);
    boolean deleteAccountById(long id);
    boolean updateAccount(Account account);
    Account cheackLoginData(String userName,String password);
    Account findAccountByUserName(String userName);
}
