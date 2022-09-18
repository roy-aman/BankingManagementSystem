package roy.aman.bankingmanagementsystem.ServiceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roy.aman.bankingmanagementsystem.Entity.*;
import roy.aman.bankingmanagementsystem.Entity.SupportEntity.AccountDTO;
import roy.aman.bankingmanagementsystem.Entity.SupportEntity.Constants;
import roy.aman.bankingmanagementsystem.Entity.SupportEntity.UserDTO;
import roy.aman.bankingmanagementsystem.Exceptions.GlobalException;
import roy.aman.bankingmanagementsystem.Exceptions.ResourceNotFoundException;
import roy.aman.bankingmanagementsystem.Repository.AccountRepository;
import roy.aman.bankingmanagementsystem.Repository.TransactionRepository;
import roy.aman.bankingmanagementsystem.Repository.UserRepository;
import roy.aman.bankingmanagementsystem.Services.UserService;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO registerAsUser(UserDTO userdto) {
        User user = this.modelMapper.map(userdto,User.class);
        user = userRepository.save(user);
        return this.modelMapper.map(user,UserDTO.class);
    }


    @Override
    public Account openAccount(AccountDTO accountDTO, Integer userID) {

        Account account = null;

        if(accountDTO.accountType.equals("SAVING")){

            account = new SavingAccount();
            account.setAccountHolder(accountDTO.user);
            account.setAccountType(accountDTO.accountType);

            if(accountDTO.amount>= Constants.SAVING_ACCOUNT_OPENING_BALANCE){
                account.setTotalAmount(accountDTO.amount);
            }
            else throw new RuntimeException("Opening Amount of Saving account in minimum 10000");

            return accountRepository.save(account);

        }
        // If selected account type is Current (#OpenCurrentAccount)
        else if (accountDTO.accountType.equals("CURRENT")) {

           account= this.modelMapper.map(accountDTO, CurrentAccount.class);

           // minimum opening balance condition
           if(account.getTotalAmount()< Constants.CURRENT_ACCOUNT_OPENING_BALANCE){
               throw new RuntimeException(Constants.CREATE_ACCOUNT_FAILED);
           }
           // a minimum age limit of 18 Years to open a Current account
            User user = this.userRepository.findById(userID).orElseThrow( ()-> new ResourceNotFoundException("User","userId",userID));

                                                                           //()-> is important
          LocalDate today = LocalDate.now();
          Date dob = user.getDateOfBirth();

          Period period = Period.ofYears(dob.getYear());
           if(period.getYears() < Constants.SAVING_ACCOUNT_Age_LIMIT){
               throw new RuntimeException("To opern this account minimum age should be 18");
           }

           // add other conditions


           return this.accountRepository.save(account);

        }
        // #Opening a LoanAccount
        else if(accountDTO.accountType.equals("LOAN")) {

            account= this.modelMapper.map(accountDTO, LoanAccount.class);


            return this.accountRepository.save(account);

        }

        throw new RuntimeException("Please select a valid accountType"+accountDTO.accountType+" is not a valid type");

    }

    @Override
    public AccountDTO getActiveAccount(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow( ()-> new ResourceNotFoundException("User","userId",userId));

       return this.modelMapper.map(user.getActiveAccounts(),AccountDTO.class) ;
    }

    @Override
    public UserDTO updateDetails(UserDTO userDto, Integer userId) {

        User user = this.userRepository.findById(userId).orElseThrow( ()-> new ResourceNotFoundException("User","userId",userId));

        user = userRepository.save(user);
        return this.modelMapper.map(user,UserDTO.class) ;

    }
}
