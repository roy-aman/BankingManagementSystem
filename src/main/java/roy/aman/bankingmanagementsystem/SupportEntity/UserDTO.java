package roy.aman.bankingmanagementsystem.SupportEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.UniqueConstraint;
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
    @Column(unique = true)
    @Size(min=10,max = 10, message = "Number must be of 10 digits !!")
    private String mobileNumber;

    @NotEmpty
    private Date dateOfBirth;
    @NotEmpty
    private String address;

}
