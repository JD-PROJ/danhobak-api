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
                .headers().frameOptions().disable() //h2console ȭ���� ����ϱ����� �ش� �ɼ� disable
                .and()
                    .authorizeRequests()
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll() //�ش� url�� ��� ��ü���� ���Ѱ���
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //POST�޼ҵ�鼭 �ش� �ּ��� API�� USER���� ����� ��������
                    .anyRequest().authenticated() //������ �̿��ǰ��� ������ ����ڸ�(=�α��ε�)
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                        .userService(customOAuth2UserService);
    }
}
