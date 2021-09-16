package br.com.rvz.hrapigatewayzuul.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.logging.Filter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    private final static Logger log = LoggerFactory.getLogger(ResourceServerConfig.class);
    private final static String[] PUBLIC = {"/hr-oauth/ouath/token"};
    private final static String[] OPERATOR = { "/hr-worker/**" };
    private final static String[] ADMIN = { "/hr-payroll/**", "/hr-user/**"};

    private final JwtTokenStore jwtTokenStore;

    public ResourceServerConfig(JwtTokenStore jwtTokenStore) {
        this.jwtTokenStore = jwtTokenStore;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        log.info("configure resource jwt token");
        resources.tokenStore(jwtTokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        log.info("configurar regras de acessos");
        http.csrf().disable().requestMatcher(EndpointRequest.toAnyEndpoint()).
        authorizeRequests().antMatchers(PUBLIC).permitAll()
                .antMatchers(HttpMethod.GET, OPERATOR).hasAnyRole("OPERATOR", "ADMIN")
                .antMatchers(ADMIN).hasRole("ADMIN")
                .anyRequest().authenticated().and().httpBasic();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public ObjectPostProcessor createObjectPostProcess() {
        return new ObjectPostProcessor() {
            @Override
            public Object postProcess(Object o) {
                return null;
            }
        };
    }

    @Bean
    public AuthenticationConfiguration createAutenticationConfiguration() {
        return new AuthenticationConfiguration();
    }
}
