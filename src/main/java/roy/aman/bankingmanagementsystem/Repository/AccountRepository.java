package roy.aman.bankingmanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import roy.aman.bankingmanagementsystem.Entity.Account;

public interface AccountRepository extends JpaRepository <Account, Integer>{

}
