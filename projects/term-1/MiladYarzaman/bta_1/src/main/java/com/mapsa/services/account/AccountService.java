package com.mapsa.services.account;

import com.mapsa.dao.account.IAccount;
import com.mapsa.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    IAccount accountDaoImpl;
   public long createAccount(Account account) throws CustomExeption {
       /*account.setEmail("milad.yar");
       account.setPassword("123456");
       account.setNationalCode("581000");*/
       Account account1= accountDaoImpl.findAccountByUserName(account.getEmail());
       long id;
       if(account1==null){
           try {
              id= accountDaoImpl.createAccount(account);
               return id;
           }catch (CustomExeption customExeption){
               customExeption.printStackTrace();
               System.out.println(customExeption.getMessage());
               throw new CustomExeption(customExeption.getMessage());
           }

       }else{
           throw new CustomExeption(ConstVariable.EMAIL_OR_NATIONAL_CODE_IS_ALREADY);
       }

    }
   public List<Account> getAccountList(){
        List<Account> accountList=new ArrayList<>();
        accountList=accountDaoImpl.getAccountList();
        if(accountList!=null){
            return accountList;
        }else{return null;}
    }
   /* Account getAccountById(long accountId);
    boolean deleteAccountById(long id);
    boolean updateAccount(Account account);
    Account cheackLoginData(String userName,String password);
    Account findAccountByUserName(String userName);*/
}
