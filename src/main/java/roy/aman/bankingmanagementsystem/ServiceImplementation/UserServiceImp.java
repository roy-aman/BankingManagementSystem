package roy.aman.bankingmanagementsystem.ServiceImplementation;

import org.springframework.data.repository.query.parser.Part;
import org.springframework.stereotype.Service;
import roy.aman.bankingmanagementsystem.Entity.Account;
import roy.aman.bankingmanagementsystem.Entity.SupportEntity.AccountDTO;
import roy.aman.bankingmanagementsystem.Entity.SupportEntity.UserDTO;
import roy.aman.bankingmanagementsystem.Entity.User;
import roy.aman.bankingmanagementsystem.Repository.TransactionRepository;
import roy.aman.bankingmanagementsystem.Repository.UserRepository;
import roy.aman.bankingmanagementsystem.Services.UserService;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;
    private TransactionRepository transactionRepository;

    @Override
    public UserDTO registerAsUser(UserDTO user) {
        return null;
    }


    @Override
    public Integer openAccount(AccountDTO accountDTO) {

        Account account = new Account();
        account.setAccountHolder(accountDTO.user);

        account.setAccountType(accountDTO.accountType);

        if(account.getAccountType().equals("SAVING")){
            if(accountDTO.amount>=10000){
                account.setTotalAmount(accountDTO.amount);
            }
            else throw new RuntimeException("Opening Amount of Saving account in minimum 10000");
        }

        return null;
    }

    @Override
    public List<AccountDTO> getAllAccounts(Integer userId) {
        return null;
    }

    @Override
    public UserDTO updateDetails(UserDTO userDto, Integer userId) {
        return null;
    }
}
