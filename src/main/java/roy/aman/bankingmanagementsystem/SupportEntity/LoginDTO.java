package roy.aman.bankingmanagementsystem.SupportEntity;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class LoginDTO {
    // this loginDto can be used for both account and user login

//    @NotEmpty
    String accountNumber;
//    @NotEmpty
    Integer userId;
    @NotEmpty
    String accountPassword;
//    @Email(message = "Email address is not valid !!")
//    private String email;
}
