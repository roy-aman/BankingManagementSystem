package roy.aman.bankingmanagementsystem.SupportEntity;

import roy.aman.bankingmanagementsystem.Entity.User;

import java.util.Date;


public class AccountDTO {

    public Long amount;

    public Date dateOfOpening;

    public AccountType accountType;

    public User user;

    public String password;
}
