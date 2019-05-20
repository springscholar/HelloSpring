package com.hr.learning.projectbackend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    AuthenticationManager authenticationManager;

    static class CorsFilter implements Filter{

        @Override
        public void destroy() {
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter) throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;

            res.addHeader("Access-Control-Allow-Origin","http://localhost:4200");
            res.addHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,DELETE");
            res.addHeader("Access-Control-Max-Age","3600");
            res.addHeader("Access-Control-Allow-Headers","Authorization, Content-Type");
            res.addHeader("Access-Control-Expose-Headers","*");
            res.addHeader("Access-Control-Allow-Credentials","true");

            if (req.getMethod().equalsIgnoreCase("OPTIONS")) {
                res.setStatus(200);
            }else{
                filter.doFilter(req,res);
            }
        }

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.addTokenEndpointAuthenticationFilter(new CorsFilter());
    }

    /**
     * Configure auth server that only user name client with password secret is able to issue a temporary access token
     *
      * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.
                inMemory().
                withClient("client").
                secret("{noop}secret").
                authorizedGrantTypes("password").
                resourceIds("oauth2-resource").
                scopes("read");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }
}
