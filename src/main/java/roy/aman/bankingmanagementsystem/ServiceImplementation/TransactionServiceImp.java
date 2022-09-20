package roy.aman.bankingmanagementsystem.ServiceImplementation;

import net.bytebuddy.implementation.bytecode.Throw;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roy.aman.bankingmanagementsystem.Entity.Account;
import roy.aman.bankingmanagementsystem.Entity.Transaction;
import roy.aman.bankingmanagementsystem.Exceptions.ResourceNotFoundException;
import roy.aman.bankingmanagementsystem.Repository.AccountRepository;
import roy.aman.bankingmanagementsystem.Repository.TransactionRepository;
import roy.aman.bankingmanagementsystem.SupportEntity.AtmTransDTO;
import roy.aman.bankingmanagementsystem.Services.TransactionService;
import roy.aman.bankingmanagementsystem.SupportEntity.TransactionDTO;

import javax.persistence.Access;

@Service
public class TransactionServiceImp implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Integer withdrawThroughBank(TransactionDTO TransDTO) {

       Account account = this.accountRepository.findById(TransDTO.getAccountNumber()).orElseThrow(()-> new ResourceNotFoundException("Account","AccountNumber",TransDTO.getAccountNumber()+""));

       if(account.getLoginStatus()){
           account.setTotalAmount(account.getTotalAmount() - TransDTO.getAmount());
           Transaction transaction = this.modelMapper.map(TransDTO, Transaction.class);

           this.transactionRepository.save(transaction);
           this.accountRepository.save(account);

           return account.getTotalAmount();
       }
       throw new RuntimeException("Please try to login First");
    }

    @Override
    public Integer withdrawThroughATM(AtmTransDTO TransDTO) {

        // functions are under construction


        throw new RuntimeException("Invalid Transaction Type");

    }

    @Override
    public Integer transferMoney(TransactionDTO transDTO) {

        Account account = this.accountRepository.findById(transDTO.getAccountNumber()).orElseThrow(()-> new ResourceNotFoundException("Account","AccountNumber",transDTO.getAccountNumber()+""));

        if(account.getLoginStatus()){
            account.setTotalAmount(account.getTotalAmount() - transDTO.getAmount());
            Transaction transaction = this.modelMapper.map(transDTO, Transaction.class);

            this.transactionRepository.save(transaction);
            this.accountRepository.save(account);

            return account.getTotalAmount();
        }
        throw new RuntimeException("Please try to login First");
    }

    @Override
    public Integer depositMoney(TransactionDTO transDTO) {

        Account account = this.accountRepository.findById(transDTO.getAccountNumber()).orElseThrow(()-> new ResourceNotFoundException("Account","AccountNumber",transDTO.getAccountNumber()+""));

        if(account.getLoginStatus()){
            account.setTotalAmount(account.getTotalAmount() + transDTO.getAmount());
            Transaction transaction = this.modelMapper.map(transDTO, Transaction.class);

            this.transactionRepository.save(transaction);
            this.accountRepository.save(account);

            return account.getTotalAmount();
        }
        throw new RuntimeException("Please try to login First");    }
}
