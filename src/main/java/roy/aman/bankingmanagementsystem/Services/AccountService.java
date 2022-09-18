package roy.aman.bankingmanagementsystem.Services;

import roy.aman.bankingmanagementsystem.Entity.SupportEntity.AtmTransDTO;
import roy.aman.bankingmanagementsystem.Entity.SupportEntity.BankTransDTO;
import roy.aman.bankingmanagementsystem.Entity.SupportEntity.LoginDTO;
import roy.aman.bankingmanagementsystem.Entity.Transaction;

import java.util.List;

public interface AccountService {

    String logIn(LoginDTO loginDTO);

    String logOut();

    List<Transaction> getTransactionDetails();

    String closeAccount();

}
