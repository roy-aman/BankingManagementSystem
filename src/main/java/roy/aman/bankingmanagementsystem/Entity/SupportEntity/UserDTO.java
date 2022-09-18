package roy.aman.bankingmanagementsystem.Entity.SupportEntity;

import lombok.*;
import roy.aman.bankingmanagementsystem.Entity.Address;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
public class UserDTO {

    @NotEmpty
    @Size(min = 4, message = "Username must be min of 4 characters !!")
    private String fullName;

    @Email(message = "Email address is not valid !!")
    private String email;

    @NotEmpty
    @Size(min = 3, max = 10, message = "Password must be min of 3 chars and max of 10 chars !!")
    private String password;

    @NotEmpty
    private Date dateOfBirth;
    @NotEmpty
    private String address;

}
