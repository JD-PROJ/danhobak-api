package com.jidong.danhobak.config.auth;

import com.jidong.danhobak.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .headers().frameOptions().disable() //h2console 화면을 사용하기위해 해당 옵션 disable
                .and()
                    .authorizeRequests()
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll() //해당 url은 모두 전체열람 권한가짐
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //POST메소드면서 해당 주소인 API는 USER권한 사람만 열람가능
                    .anyRequest().authenticated() //설정된 이외의값은 인증된 사용자만(=로그인된)
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                        .userService(customOAuth2UserService);
    }
}
