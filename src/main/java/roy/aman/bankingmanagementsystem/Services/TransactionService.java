package roy.aman.bankingmanagementsystem.Services;

import roy.aman.bankingmanagementsystem.SupportEntity.AtmTransDTO;
import roy.aman.bankingmanagementsystem.SupportEntity.BankTransDTO;

public interface TransactionService  {

    Integer withdrawThroughBank(BankTransDTO bankTransDTO);

    Integer withdrawThroughATM(AtmTransDTO bankTransDTO);

    Integer transferMoney(BankTransDTO bankTransDTO);

    Integer depositMoney(Integer amount);
}
