package roy.aman.bankingmanagementsystem.ServiceImplementation;

import org.springframework.stereotype.Service;
import roy.aman.bankingmanagementsystem.SupportEntity.AtmTransDTO;
import roy.aman.bankingmanagementsystem.SupportEntity.BankTransDTO;
import roy.aman.bankingmanagementsystem.Services.TransactionService;

@Service
public class TransactionServiceImp implements TransactionService {
    @Override
    public Integer withdrawThroughBank(BankTransDTO bankTransDTO) {
        return null;
    }

    @Override
    public Integer withdrawThroughATM(AtmTransDTO bankTransDTO) {
        return null;
    }

    @Override
    public Integer transferMoney(BankTransDTO bankTransDTO) {
        return null;
    }

    @Override
    public Integer depositMoney(Integer amount) {
        return null;
    }
}
