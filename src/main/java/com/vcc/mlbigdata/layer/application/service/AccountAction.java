package com.vcc.mlbigdata.layer.application.service;

import com.vcc.mlbigdata.layer.application.domain.model.Account;
import com.vcc.mlbigdata.layer.presentation.controller.API;

public class AccountAction {
    long accountID;
    double subMoney;
    double addMoney;
    Account accountExcute = new Account();

    //public void insert(long accountID, String accountName, double availableBalances){}

    //

    public void comeIn(double addMoney){
        if (accountExcute.getSubMoney() < 0) {
            System.out.println("Số tiền nhập không hợp lệ");
        } else {
            this.addMoney = accountExcute.getAvailableBalances() + addMoney;
        }
    }

    public void comeOut(double subMoney){
        if (subMoney < 0) {
            System.out.println("Số tiền nhập không hợp lệ");
        } else if(subMoney >= accountExcute.getAvailableBalances()){
            System.out.println("Số dư không đủ!");
        } else{
            this.subMoney = accountExcute.getAvailableBalances() - (subMoney + accountExcute.getSubMoneyFee());
        }
    }

    public void mature(){
//        accountExcute.setAvailableBalances() += accountExcute.getAvailableBalances() * accountExcute.getInterestRate();
    }

    public void transferMoney(double transferMoney){
        if (transferMoney < 0) {
            System.out.println("Số tiền nhập không hợp lệ");
        }else if(transferMoney > accountExcute.getAvailableBalances()){
            System.out.println("Số dư không đủ!");
        } else{
            this.subMoney = accountExcute.getAvailableBalances() - transferMoney;
        }
    }

    public void receiveMoney(double transferMoney){
        this.addMoney = accountExcute.getAvailableBalances() + transferMoney;
    }
}
