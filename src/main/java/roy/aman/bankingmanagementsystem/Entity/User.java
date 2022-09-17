package roy.aman.bankingmanagementsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Integer userID;

    private String email;
    private String fullName;
    private String username;
    private Date dateOfBirth;
    private String password;

    @OneToOne
    @JoinColumn(name = "address_add_id")
    private Address address;

}
