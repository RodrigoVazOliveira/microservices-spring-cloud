package br.com.rvz.hroauth.controllers;

import br.com.rvz.hroauth.entities.User;
import br.com.rvz.hroauth.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/users/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("search")
    @ResponseStatus(HttpStatus.OK)
    public User findByEmail(@RequestParam String email) {
       try {
           return userService.findByEmail(email);
       } catch (IllegalArgumentException e) {
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
       }
    }

    @GetMapping("{id}/")
    @ResponseStatus(HttpStatus.OK)
    public User findById(@PathVariable Long id) {
        try {
            return userService.findById(id);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
