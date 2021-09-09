package br.com.rvz.hroauth.services;

import br.com.rvz.hroauth.entities.User;
import br.com.rvz.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final static Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserFeignClient userFeignClient;

    public UserService(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email);

        if (user == null) {
            log.error("findByEmail email: {}", email);
            throw new IllegalArgumentException("Usuário com e-mail " + email + "não foi localizado!");
        }

        return user;
    }
}
