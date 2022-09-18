package roy.aman.bankingmanagementsystem.Services;

import roy.aman.bankingmanagementsystem.Entity.Account;
import roy.aman.bankingmanagementsystem.Entity.SupportEntity.AccountDTO;
import roy.aman.bankingmanagementsystem.Entity.SupportEntity.UserDTO;
import roy.aman.bankingmanagementsystem.Entity.User;

import java.util.List;

public interface UserService {

    UserDTO registerAsUser(UserDTO user);
    Integer openAccount(AccountDTO accountDTO);

    List<AccountDTO> getAllAccounts(Integer userId);

    UserDTO updateDetails(UserDTO user, Integer userId);

}
