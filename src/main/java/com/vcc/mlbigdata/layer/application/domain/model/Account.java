package com.vcc.mlbigdata.layer.application.domain.model;

public class Account {
    private long accountID;
    private String accountName;
    private double availableBalances;

    private double addMoney;
    private double subMoney;
    private double matureMoney;
    private double transferMoney;
    private final double subMoneyFee = 0.01;
    private final double interestRate = 0.035;

    public Account(){};

    public Account(long l, String s, double d){
        accountID = l;
        accountName = s;
        availableBalances = d;
    }

    public Account(long l, String s){
        accountID = l;
        accountName = s;
        double availableBalances = 50;
    }

    public long getAccountID(){ return accountID; }

    public void setAccountID(long accountID){ this.accountID = accountID; }

    public String getAccountName(){
        return accountName;
    }

    public void setAccountName(String accountName){
        this.accountName = accountName;
    }

    public double getAvailableBalances(){
        return availableBalances;
    }

    public void setAvailableBalances(double availableBalances){
        this.availableBalances = availableBalances;
    }
    public double getAddMoney() {
        return addMoney;
    }

    public void setAddMoney(double addMoney) {
        this.addMoney = addMoney;
    }

    public void setSubMoney(double subMoney) {
        this.subMoney = subMoney;
    }

    public void setMatureMoney(double matureMoney) {
        this.matureMoney = matureMoney;
    }

    public void setTransferMoney(double transferMoney) {
        this.transferMoney = transferMoney;
    }

    public double getSubMoney() {
        return subMoney;
    }

    public double getMatureMoney() {
        return matureMoney;
    }

    public double getTransferMoney() {
        return transferMoney;
    }

    public double getSubMoneyFee() {
        return subMoneyFee;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
