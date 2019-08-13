package com.duanxin.gmall.user.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Druid配置类
 * @author duanxin
 * @version 1.0
 * @date 2019/8/11 17:30
 */
@Configuration
public class DruidConfig {

    /**
     * 配置Druid数据库连接池
     * @param []
     * @date 2019/8/11 17:31
     * @return javax.sql.DataSource
     **/
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    /**
     * 对Druid的界面进行配置
     * @param []
     * @date 2019/8/11 17:34
     * @return org.springframework.boot.web.servlet.ServletRegistrationBean
     **/
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        // todo
        Map<String, String> map = new HashMap<>();
        map.put("loginUsername", "admin");
        map.put("loginPassword", "admin");
        map.put("allow", "localhost");
        bean.setInitParameters(map);

        return bean;
    }

    /**
     * 对Druid的过滤器进行配置
     * @param []
     * @date 2019/8/11 17:38
     * @return org.springframework.boot.web.servlet.FilterRegistrationBean
     **/
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        bean.setUrlPatterns(Arrays.asList("/*"));

        // todo
        Map<String, String> map = new HashMap<>();
        map.put("profileEnable", "true");
        map.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(map);

        return bean;
    }

}
