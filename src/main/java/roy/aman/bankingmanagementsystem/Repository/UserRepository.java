package roy.aman.bankingmanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import roy.aman.bankingmanagementsystem.Entity.User;

public interface UserRepository extends JpaRepository <User, Integer>{

}
