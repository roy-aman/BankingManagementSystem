package roy.aman.bankingmanagementsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import roy.aman.bankingmanagementsystem.Services.AccountService;
import roy.aman.bankingmanagementsystem.SupportEntity.LoginDTO;
import roy.aman.bankingmanagementsystem.Entity.Transaction;
import roy.aman.bankingmanagementsystem.SupportEntity.TransactionDTO;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/login")
    public ResponseEntity<String> logIn(@RequestBody LoginDTO loginDTO) {

        return ResponseEntity.ok(this.accountService.logIn(loginDTO));
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logOut(@RequestBody String accountNumber) {
        return ResponseEntity.ok(this.accountService.logOut(accountNumber));

    }

    @GetMapping("{accountNumber}/transactions")
    public ResponseEntity<List<TransactionDTO>> getTransactionDetails(@PathVariable String AccountNumber) {

        return ResponseEntity.ok(this.accountService.getTransactionDetails(AccountNumber));
    }

    @GetMapping("/{accountNumber}/closeaccount")
    public ResponseEntity<String> closeAccount(@PathVariable String AccountNumber) {

        return ResponseEntity.ok(this.accountService.closeAccount(AccountNumber));
    }
}
