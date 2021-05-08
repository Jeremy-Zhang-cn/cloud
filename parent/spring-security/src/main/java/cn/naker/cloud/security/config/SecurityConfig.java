package cn.naker.cloud.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Zhang Dingjie
 * @date 2021/5/8
 * @Description
 */
@Configuration
@EnableWebSecurity
// 开启权限注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication()
				.withUser("admin")
				.password(bCryptPasswordEncoder().encode("admin123"))
				.roles("ADMIN");

		auth.inMemoryAuthentication()
				.withUser("dev")
				.password(bCryptPasswordEncoder().encode("dev123"))
				.roles("DEV");

		auth.inMemoryAuthentication()
				.withUser("guest")
				.password(bCryptPasswordEncoder().encode("123456"))
				.roles("GUEST");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()	//开启登录配置
				// /sys/security/** 下的接口需要具备ADMIN角色
			.antMatchers("/sys/security/**").access("hasRole('ADMIN')")
				// 其它接口登录后可以访问
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.failureUrl("/login?error")
				// 自定义登录页面
//				.loginPage()
				// 自定义登录处理逻辑
//				.loginProcessingUrl("/doLogin")
				// 登录相关接口直接放行
				.and()
				.logout()
				.logoutSuccessUrl("/login?logout")
				.permitAll()
				.and()
				.cors()
				.and()
				.csrf().disable();
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
