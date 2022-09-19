package roy.aman.bankingmanagementsystem.SupportEntity;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import roy.aman.bankingmanagementsystem.Entity.User;
import roy.aman.bankingmanagementsystem.Repository.AccountRepository;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class AccountNumberGenerator implements IdentifierGenerator {

    String prefix="AC"; // to show that it's an accountNumber;


    LocalDate date = LocalDate.now();
    int month = date.getMonthValue();
    int day = date.getDayOfMonth();
    String suffix =""+day+month; // to make more unique

    // gerenating a 10 digit number;
    public static long generateID() {
        Random rnd = new Random();
        char [] digits = new char[11];
        digits[0] = (char) (rnd.nextInt(9) + '1');
        for(int i=1; i<digits.length; i++) {
            digits[i] = (char) (rnd.nextInt(10) + '0');
        }
        return Long.parseLong(new String(digits));
    }


    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return prefix+generateID()+suffix;
    }
}
