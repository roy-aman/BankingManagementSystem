package roy.aman.bankingmanagementsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import roy.aman.bankingmanagementsystem.Entity.SupportEntity.AccountDTO;
import roy.aman.bankingmanagementsystem.Entity.SupportEntity.UserDTO;
import roy.aman.bankingmanagementsystem.Services.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //Post - Be A user of this application
    @PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDto) {
        UserDTO createUserDto = this.userService.registerAsUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    // PUT- update user details
    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDto, @PathVariable("userId") Integer uid) {
        UserDTO updatedUser = this.userService.updateDetails(userDto, uid);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/{userId}/account")
    public ResponseEntity<AccountDTO> getUsersAccounts(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getActiveAccount(userId));
    }

}
