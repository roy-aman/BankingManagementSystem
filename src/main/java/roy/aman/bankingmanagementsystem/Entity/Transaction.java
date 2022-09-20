package roy.aman.bankingmanagementsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import roy.aman.bankingmanagementsystem.SupportEntity.TransactionType;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer transId;

    private Integer amount;
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "account_Id")
    private Account account;


}

