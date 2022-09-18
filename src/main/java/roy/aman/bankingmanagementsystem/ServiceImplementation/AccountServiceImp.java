package roy.aman.bankingmanagementsystem.ServiceImplementation;

import org.springframework.stereotype.Service;
import roy.aman.bankingmanagementsystem.Entity.SupportEntity.LoginDTO;
import roy.aman.bankingmanagementsystem.Entity.Transaction;
import roy.aman.bankingmanagementsystem.Services.AccountService;

import java.util.List;

@Service
public class AccountServiceImp implements AccountService {
    @Override
    public String logIn(LoginDTO loginDTO) {
        return null;
    }

    @Override
    public String logOut() {
        return null;
    }

    @Override
    public List<Transaction> getTransactionDetails() {
        return null;
    }

    @Override
    public String closeAccount() {
        return null;
    }
}
