package DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccountDTO {
    private Long uid;
    private String number;
    private String masterName;
    private int balance;
    private int deposit;
    private int withdraw;
    private String createdAT;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(int withdraw) {
        this.withdraw = withdraw;
    }

    public String getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(String createdAT) {
        this.createdAT = createdAT;
    }
    private static Long uidValue = 1l;
    public AccountDTO(){}

    public AccountDTO(String number, String masterName) {
        this.uid = uidValue++;
        this.number = number;
        this.masterName = masterName;
        this.balance = 0;
        this.deposit = 0;
        this.withdraw = 0;
        this.createdAT = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초"));
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "uid=" + uid +
                ", number='" + number + '\'' +
                ", masterName='" + masterName + '\'' +
                ", balance=" + balance +
                ", deposit=" + deposit +
                ", withdraw=" + withdraw +
                ", createdAT=" + createdAT +
                '}';
    }
}
