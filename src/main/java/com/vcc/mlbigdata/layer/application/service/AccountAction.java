package com.vcc.mlbigdata.layer.application.service;

import com.vcc.mlbigdata.layer.application.domain.model.Account;
import com.vcc.mlbigdata.layer.presentation.controller.API;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AccountAction {
    long accountID;
    double subMoney;
    double addMoney;
    private static final Logger logger = LoggerFactory.getLogger(AccountAction.class);
    Account accountExcute = new Account();

    //public void insert(long accountID, String accountName, double availableBalances){}

    public void validateCreateUser(JSONObject jsonObject){
        List<String> missingMessage = new ArrayList<>();
        Set<String> keySet = jsonObject.keySet();
        if (!keySet.contains("accountID")){
            missingMessage.add("Missing object 'accountID'.");
        }
        if (!keySet.contains("accountName")){
            missingMessage.add("Missing object 'accountName'.");
        }
        for (String key: keySet){
            Object value = jsonObject.get(key);
            if (key.equals("accountID")) {
                if (!(value instanceof String)) {
                    missingMessage.add(String.format("Object '%s' required [%s] value, found [%s]. ",
                            key, String.class.getSimpleName(), value.getClass().getSimpleName()));
                }
                try {
                    Long.parseLong(value.toString());
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                    missingMessage.add("Invalid type of value of accountID" + e.getMessage());
                }
            }
        }
    }
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
