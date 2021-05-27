package com.vcc.mlbigdata.layer.application.service;

import com.vcc.mlbigdata.layer.application.domain.model.Account;

public class AccountAction {
    long accountID;
    double subMoney;
    double addMoney;

    Account accountExcute = new Account();

    public void ComeIn(double addMoney){
        if (accountExcute.getSubMoney() < 0) {
            System.out.println("Số tiền nhập không hợp lệ");
        } else {
            this.addMoney = accountExcute.getAvailableBalances() + addMoney;
        }
    }

    public void ComeOut(double subMoney){
        if (subMoney < 0) {
            System.out.println("Số tiền nhập không hợp lệ");
        } else if(subMoney >= accountExcute.getAvailableBalances()){
            System.out.println("Số dư không đủ!");
        } else{
            this.subMoney = accountExcute.getAvailableBalances() - (subMoney + accountExcute.getSubMoneyFee());
        }
    }

    public void Mature(){
        accountExcute.setAvailableBalances() += accountExcute.getAvailableBalances() * accountExcute.getInterestRate();
    }

    public void TransferMoney(double transferMoney){
        if (transferMoney < 0) {
            System.out.println("Số tiền nhập không hợp lệ");
        }else if(transferMoney > accountExcute.getAvailableBalances()){
            System.out.println("Số dư không đủ!");
        } else{
            this.subMoney = accountExcute.getAvailableBalances() - transferMoney;
        }
    }

    public void ReceiveMoney(double transferMoney){
        this.addMoney = accountExcute.getAvailableBalances() + transferMoney;
    }
}


 */