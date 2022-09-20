package roy.aman.bankingmanagementsystem.Controller;

import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import roy.aman.bankingmanagementsystem.Entity.Account;
import roy.aman.bankingmanagementsystem.SupportEntity.AccountDTO;
import roy.aman.bankingmanagementsystem.SupportEntity.UserDTO;
import roy.aman.bankingmanagementsystem.Services.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    //Post - Be A user of this application
    @PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDto) {
        UserDTO createUserDto = this.userService.registerAsUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }
   @PostMapping("/{userId}/openAccount")
    public ResponseEntity<AccountDTO> openAccount(@NotNull  @RequestBody AccountDTO accountDTO, @PathVariable("userId") Integer userId){

        Account account = this.userService.openAccount(accountDTO,userId);

        return ResponseEntity.ok(this.modelMapper.map(account,AccountDTO.class));
    }

    // PUT- update user details
    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDto, @PathVariable("userId") Integer uid) {
        UserDTO updatedUser = this.userService.updateDetails(userDto, uid);
        return ResponseEntity.ok(updatedUser);
    }

    //
    @GetMapping("/{userId}/account")
    public ResponseEntity<List<AccountDTO>> getUsersAccounts(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getActiveAccounts(userId));
    }

}
