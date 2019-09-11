package com.lin.cangkusp.common.config;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean filter = new ShiroFilterFactoryBean();
        filter.setLoginUrl("login.html");
        filter.setSuccessUrl("index.html");
        filter.setUnauthorizedUrl("login.html");
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("/login.html","anon");
        map.put("/verifycode","anon");
        map.put("/user/login","anon");
        map.put("/data/**","anon");
        map.put("/dist/**","anon");
        map.put("/js/**","anon");
        map.put("/less/**","anon");
        map.put("/vendor/**","anon");
        map.put("/logout","logout");
        map.put("/**","authc");
        filter.setFilterChainDefinitionMap(map);
        filter.setSecurityManager(securityManager());
        return filter;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        securityManager.setSessionManager(sessionManager());
        securityManager.setCacheManager(cacheManager());
        return securityManager;
    }

    @Bean
    public SessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(3600000);
        sessionManager.setSessionValidationInterval(600000);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }

    @Bean
    public CacheManager cacheManager(){
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:config/ehcache.xml");
        return  cacheManager;
    }

    @Bean
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }
}
