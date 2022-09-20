package roy.aman.bankingmanagementsystem.Services;

import roy.aman.bankingmanagementsystem.SupportEntity.AtmTransDTO;
import roy.aman.bankingmanagementsystem.SupportEntity.TransactionDTO;

public interface TransactionService  {

    Integer withdrawThroughBank(TransactionDTO TransDTO);

    Integer withdrawThroughATM(AtmTransDTO TransDTO);

    Integer transferMoney(TransactionDTO TransDTO);

    Integer depositMoney(TransactionDTO transDTO);
}
