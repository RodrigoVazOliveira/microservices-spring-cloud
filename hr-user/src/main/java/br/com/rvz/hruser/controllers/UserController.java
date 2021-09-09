package br.com.rvz.hruser.controllers;

import br.com.rvz.hruser.entities.User;
import br.com.rvz.hruser.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users/")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}/")
    @ResponseStatus(HttpStatus.OK)
    public User obterUsuarioPorId(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            return new User();
        }

        return optionalUser.get();
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public User pesquisarUsuarioPorEmail(@RequestParam(name = "email") String email) {
        return userRepository.findByEmail(email);
    }
}
