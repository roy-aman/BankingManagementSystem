package roy.aman.bankingmanagementsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import roy.aman.bankingmanagementsystem.Entity.SupportEntity.AccountType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="account_seq")
    @SequenceGenerator(
            name="account_seq",
            sequenceName="account_sequence",
            allocationSize=10
    )
    private int accountNumber;

    private Integer totalAmount;

    private Date dateOfOpenaning;

    private AccountType accountType;

    @ManyToOne
    @JoinColumn(name = "account_holder_id")
    private User accountHolder;

    @OneToMany
    private List<Transaction> allTrasactions;

}
