package roy.aman.bankingmanagementsystem.Entity.SupportEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
