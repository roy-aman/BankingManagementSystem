package roy.aman.bankingmanagementsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import roy.aman.bankingmanagementsystem.Entity.Transaction;
import roy.aman.bankingmanagementsystem.Repository.TransactionRepository;
import roy.aman.bankingmanagementsystem.Services.TransactionService;
import roy.aman.bankingmanagementsystem.SupportEntity.AtmTransDTO;
import roy.aman.bankingmanagementsystem.SupportEntity.TransactionDTO;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/withdrawThroughBank")
    ResponseEntity<String> withdrawThroughBank(@RequestBody TransactionDTO transDTO){
        Integer totalamount = transactionService.withdrawThroughBank(transDTO);

        return ResponseEntity.ok("Transaction successful, Your total amount = "+totalamount);
    }

    @PostMapping("/withdrawThroughAtm")
    ResponseEntity<String> withdrawThroughATM(@RequestBody AtmTransDTO atmTransDTO){
        // this Api is underProcess

        return ResponseEntity.ok("Please try some other ways this functionality is under construction!");
    }

    @PostMapping("/banktransfer")
    ResponseEntity<String> transferMoney(@RequestBody TransactionDTO transDTO){
        Integer totalAmount = transactionService.transferMoney(transDTO);
        return ResponseEntity.ok( "Transaction successful, Your total amount = "+totalAmount);
    }


    @PostMapping("/depositMoney")
    ResponseEntity<String>  depositMoney(@RequestBody TransactionDTO transDTO){
        Integer totalAmount = transactionService.depositMoney(transDTO);
        return ResponseEntity.ok("Deposit Successful !!, Your total amount = "+totalAmount);

    }

}
