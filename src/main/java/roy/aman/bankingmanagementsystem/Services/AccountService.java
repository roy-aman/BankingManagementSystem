package roy.aman.bankingmanagementsystem.Services;

import roy.aman.bankingmanagementsystem.SupportEntity.LoginDTO;
import roy.aman.bankingmanagementsystem.Entity.Transaction;
import roy.aman.bankingmanagementsystem.SupportEntity.TransactionDTO;

import java.util.List;

public interface AccountService {

    String logIn(LoginDTO loginDTO);

    String logOut(String AccountNumber);

    List<TransactionDTO> getTransactionDetails(String AccountNumber);

    String closeAccount(String AccountNumber);

}
