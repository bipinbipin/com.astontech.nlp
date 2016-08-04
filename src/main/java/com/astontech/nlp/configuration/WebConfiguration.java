package com.astontech.nlp.configuration;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration
{
    @Bean
    ServletRegistrationBean h2servletRegistration()
    {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new org.h2.server.web.WebServlet());
        registrationBean.addUrlMappings("/console/*");

        return registrationBean;
    }

}
