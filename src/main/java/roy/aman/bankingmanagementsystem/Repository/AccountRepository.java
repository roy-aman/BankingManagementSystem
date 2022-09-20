package roy.aman.bankingmanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import roy.aman.bankingmanagementsystem.Entity.Account;
import roy.aman.bankingmanagementsystem.Entity.User;

import java.util.List;

public interface AccountRepository extends JpaRepository <Account, String>{

    List<Account> findByUser(User user);

}
