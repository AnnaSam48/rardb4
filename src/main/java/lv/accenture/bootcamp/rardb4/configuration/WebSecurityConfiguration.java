package lv.accenture.bootcamp.rardb4.configuration;

import lv.accenture.bootcamp.rardb4.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DelegatingPasswordEncoder delegatingPasswordEncoder;
    //  private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    private MyUserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                //  .passwordEncoder(bCryptPasswordEncoder);
                .passwordEncoder(delegatingPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        String loginPage = "/login";
        String logoutPage = "/logout";

        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("userAth/registration").permitAll()
                .antMatchers("/cats").permitAll()
                .antMatchers("/cats/**").permitAll()
                .antMatchers(loginPage).permitAll()
                .antMatchers("/password/error").permitAll()
                .antMatchers("/admin/home").permitAll()
                .antMatchers("/user/home").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/user/**").hasAuthority("USER")

                .anyRequest()
                .authenticated()
                .and().csrf().disable()
                .formLogin()
                .loginPage(loginPage)
                .loginPage("/")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/")
                .usernameParameter("user_name")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher(logoutPage))
                .logoutSuccessUrl("/").and().exceptionHandling();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**");
    }

}