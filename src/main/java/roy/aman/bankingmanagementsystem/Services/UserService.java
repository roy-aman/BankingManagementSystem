package roy.aman.bankingmanagementsystem.Services;

import roy.aman.bankingmanagementsystem.Entity.Account;
import roy.aman.bankingmanagementsystem.SupportEntity.AccountDTO;
import roy.aman.bankingmanagementsystem.SupportEntity.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO registerAsUser(UserDTO user);

    Account openAccount(AccountDTO accountDTO, Integer uid);


    List<AccountDTO> getActiveAccounts(Integer userId);

    UserDTO updateDetails(UserDTO user, Integer userId);

    // User login Logout services are required here yet
    // Account logIn LogOut is provided in Account Service

}
