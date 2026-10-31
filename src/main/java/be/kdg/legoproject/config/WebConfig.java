package be.kdg.legoproject.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

// Web configuration: lets the user switch language with ?lang=en or ?lang=nl.
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final Logger log =
            LoggerFactory.getLogger(WebConfig.class);

    // Remembers the chosen language in the user's session.
    // Without a choice it still follows the browser language.
    @Bean
    public LocaleResolver localeResolver() {
        log.debug("Creating SessionLocaleResolver");
        return new SessionLocaleResolver();
    }

    // Reads the "lang" request parameter and changes the language.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);
        log.debug("Registered LocaleChangeInterceptor with parameter 'lang'");
    }
}