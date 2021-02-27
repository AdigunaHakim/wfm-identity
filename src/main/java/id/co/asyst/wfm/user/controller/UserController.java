package id.co.asyst.wfm.user.controller;

import id.co.asyst.wfm.user.model.User;
import id.co.asyst.wfm.user.service.UserService;
import id.co.asyst.wfm.user.utils.EncodePassword;
import id.co.asyst.wfm.user.utils.LoginStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/identity/user")
public class UserController
{

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public List<User> getAllUser() {
        return (List<User>) userService.findAll();
    }

    @PostMapping("/create")
    public User createUser(@Valid @RequestBody User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        user.setPassword(EncodePassword.getSHA1(user.getPassword()));
        return (User) userService.saveOrUpdate(user);
    }

    @GetMapping("/find/{username}")
    public User getUserById(@PathVariable(value = "username") String username) {
        return (User) userService.findById(username);
    }

    @PutMapping("/update/{username}")
    public User updateUser(@PathVariable(value = "username") String username,
                           @Valid @RequestBody User userDetail) {

        User user = (User) userService.findById(username);
        user.setFullname(userDetail.getFullname());
        user.setPassword(userDetail.getPassword());
        user.setActive(userDetail.getActive());

        userService.saveOrUpdate(user);
        return user;
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "username") String username) {
        userService.deleteById(username);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public LoginStatus login(@Valid @RequestBody User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        user.setPassword(EncodePassword.getSHA1(user.getPassword()));
        return (LoginStatus) userService.login(user);
    }

}