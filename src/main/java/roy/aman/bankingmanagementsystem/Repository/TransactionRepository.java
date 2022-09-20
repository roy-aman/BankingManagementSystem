package roy.aman.bankingmanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import roy.aman.bankingmanagementsystem.Entity.Transaction;

public interface TransactionRepository extends JpaRepository <Transaction,Integer>{

}
