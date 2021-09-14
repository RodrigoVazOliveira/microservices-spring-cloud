package br.com.rvz.hroauth.feignclients;

import br.com.rvz.hroauth.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "hr-user", path = "/users/")
public interface UserFeignClient {

    @GetMapping("/search")
    User findByEmail(@RequestParam(name = "email") String email);

    @GetMapping("/{id}/")
    User findById(@PathVariable Long id);
}
