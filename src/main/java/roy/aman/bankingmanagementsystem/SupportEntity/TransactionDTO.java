package roy.aman.bankingmanagementsystem.SupportEntity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class TransactionDTO {
    @NotEmpty
    private String accountNumber;
    private TransactionType transactionType;
    @NotEmpty
    private Integer amount;
    
}
