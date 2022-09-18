package roy.aman.bankingmanagementsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import roy.aman.bankingmanagementsystem.Entity.SupportEntity.AccountType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = TABLE_PER_CLASS)
public abstract class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="account_seq")
    @SequenceGenerator(
            name="account_seq",
            sequenceName="account_sequence",
            allocationSize=10
    )
    private Integer accountNumber;

    private Integer totalAmount;

    private Date dateOfOpening;

    private AccountType accountType;

    @OneToOne
    @JoinColumn(name = "account_holder_id")
    private User accountHolder;

    @OneToMany
    private List<Transaction> allTrasactions;
    @Column(name="account_Pass")
    private String password;

    @ColumnDefault("false")
    private Boolean loginStatus;

}
