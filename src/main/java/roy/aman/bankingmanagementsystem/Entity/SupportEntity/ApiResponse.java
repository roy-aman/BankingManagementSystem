package roy.aman.bankingmanagementsystem.Entity.SupportEntity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// To Store all the api responses
public class ApiResponse {

    private String message;
    private boolean success;
}
