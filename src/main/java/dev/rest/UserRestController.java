package dev.rest;

import dev.domain.User;
import dev.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        userService.create(user);
        return "User Created";
    }
    @PutMapping("/{users}")
    public String updateUser(@PathVariable("users") int users, @RequestBody User user) {

        userService.edit(user);
        return "Update Info";
    }
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/count")
    public Long getTotalUserCount() {
        return userService.countUsers();
    }
    @GetMapping("/users/{id}")
    public User addUser(@PathVariable("id") int id) {
        return userService.get(id);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "user deleted";
    }


}
