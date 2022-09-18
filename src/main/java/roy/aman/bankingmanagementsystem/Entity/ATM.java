package roy.aman.bankingmanagementsystem.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
public class ATM {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @Column(name = "atm_number", nullable = false)
    private Long atmNumber;

    private Integer cardNumber;
    private Date expirydate;
    private Integer CVVNumber;
    @OneToOne
    private Account account;

    public Long getAtmNumber() {
        return atmNumber;
    }

    public void setAtmNumber(Long atmNumber) {
        this.atmNumber = atmNumber;
    }


}
