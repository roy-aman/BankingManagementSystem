package roy.aman.bankingmanagementsystem.Services;

import roy.aman.bankingmanagementsystem.Entity.Account;
import roy.aman.bankingmanagementsystem.Entity.SupportEntity.AccountDTO;
import roy.aman.bankingmanagementsystem.Entity.SupportEntity.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO registerAsUser(UserDTO user);
    Account openAccount(AccountDTO accountDTO, Integer uid);

    AccountDTO getActiveAccount(Integer userId);

    UserDTO updateDetails(UserDTO user, Integer userId);

}
