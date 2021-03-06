package ru.itis.demo.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;
import org.springframework.web.filter.GenericFilterBean;
import ru.itis.demo.repository.PersonRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CustomAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private CustomOAuth2UserService oauth2UserService;
    @Autowired
    private CustomOidcUserService oidcUserService;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager authenticationManager = super.authenticationManagerBean();
        log.info(authenticationManager.toString());
        return authenticationManager;
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(new LoginPageFilter(), DefaultLoginPageGeneratingFilter.class);
        http
                .authorizeRequests()
                .antMatchers("/order", "/profile").access("hasAuthority('USER')")
                .antMatchers("/**", "/registration").permitAll()
                .antMatchers("/login").not().authenticated()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").usernameParameter("email").permitAll()
                .and()
                .logout().logoutUrl("/logout").permitAll()
                .and()
                .oauth2Login()
                .loginPage("/oauth2")
                .userInfoEndpoint()
                .userService(oauth2UserService)
                .oidcUserService(oidcUserService())
                .and()
                .successHandler(authenticationSuccessHandler);
    }

    private OidcUserService oidcUserService() {
        oidcUserService.setOauth2UserService(oauth2UserService);
        return oidcUserService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    class LoginPageFilter extends GenericFilterBean {
        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            if (SecurityContextHolder.getContext().getAuthentication() != null
                    && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
                    && ((HttpServletRequest) request).getRequestURI().equals("/login")) {
                log.info("user is authenticated but trying to access login page, redirecting to /");
                ((HttpServletResponse) response).sendRedirect("/me");
            }
            chain.doFilter(request, response);
        }
    }

}
