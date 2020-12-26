package com.alexcosta.seguranca.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ConfiguracoesSpringSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        //diz que todas as requisições exigem que o usuário esteja autenticado
        .authorizeRequests().anyRequest().authenticated()
        //diz que o login será via tela html
        .and().formLogin().loginPage("/entrar").permitAll()
        //configurando o logout
        .and().logout().logoutSuccessUrl("/entrar?logout").permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
    throws Exception {
        auth.jdbcAuthentication()
        .dataSource(dataSource)
        //precisa retornar usuario, senha e status (1 = ativo, 0 = inativo)
        .usersByUsernameQuery("select email,password, 1 "
            + "from users "
            + "where email = ?")
        .authoritiesByUsernameQuery("select users.email, roles.authority from user_roles JOIN users ON users.id = user_roles.user_id JOIN roles ON roles.id = user_roles.role_id WHERE email = ?");
    }
}
