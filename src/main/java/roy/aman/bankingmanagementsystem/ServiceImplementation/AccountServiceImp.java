package roy.aman.bankingmanagementsystem.ServiceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roy.aman.bankingmanagementsystem.Entity.Account;
import roy.aman.bankingmanagementsystem.Exceptions.ResourceNotFoundException;
import roy.aman.bankingmanagementsystem.Repository.AccountRepository;
import roy.aman.bankingmanagementsystem.SupportEntity.Constants;
import roy.aman.bankingmanagementsystem.SupportEntity.LoginDTO;
import roy.aman.bankingmanagementsystem.Entity.Transaction;
import roy.aman.bankingmanagementsystem.Services.AccountService;
import roy.aman.bankingmanagementsystem.SupportEntity.TransactionDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String logIn(LoginDTO loginDTO) {
        Account account = this.accountRepository.findById(loginDTO.getAccountNumber()).orElseThrow( ()-> new ResourceNotFoundException("Account","AccountNumber",loginDTO.getAccountNumber()));

        if(account.getLoginStatus()){
            return "You are already loggedIn";
        } else if (account.getPassword().equals(loginDTO.getAccountPassword())) {
            account.setLoginStatus(true);
            this.accountRepository.save(account);
            return "Your have LoggedIn successfully";
        }
        throw new RuntimeException("Your Account Password is not valid, Try again !!");
    }

    @Override
    public String logOut(String accountNumber) {

        Account account = this.accountRepository.findById(accountNumber).orElseThrow(()->new ResourceNotFoundException("Account", "AccountNumber",accountNumber));

        if(account.getLoginStatus()){
            account.setLoginStatus(false);
            this.accountRepository.save(account);
            return "You have LoggedOut Successfully";
        }
        throw new RuntimeException("Please log in First !!");
    }

    @Override
    public List<TransactionDTO> getTransactionDetails(String accountNumber) {
       Account account = this.accountRepository.findById(accountNumber).orElseThrow(()->new ResourceNotFoundException("Account", "AccountNumber",accountNumber));
       List<Transaction> transactions = account.getAllTrasactions();

     List<TransactionDTO> transactionDTOList = transactions.stream().map( (trans)-> modelMapper.map(trans,TransactionDTO.class) ).collect(Collectors.toList());
       return transactionDTOList;
    }

    @Override
    public String closeAccount(String accountNumber) {

        Account account = this.accountRepository.findById(accountNumber).orElseThrow(()->new ResourceNotFoundException("Account", "AccountNumber",accountNumber));
        if(account.getLoginStatus()){
            accountRepository.delete(account);
            return "Your account has been successfully deleted";
        }

        throw new RuntimeException("Please login to this account first !!");
    }
}
