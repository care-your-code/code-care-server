package site.codecare.global.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class AppConfig {
    @Getter
    private static ApplicationContext context;
    private static String activeProfile;
    @Getter
    private static String siteName;
    @Getter
    private static String siteBaseUrl;

    @Getter
    public static double wholesalePriceRate;

    @Getter
    public static int cancelAvailableSeconds;

    @Autowired
    public void setContext(ApplicationContext context) {
        AppConfig.context = context;
    }

//    @Value("${custom.rebate.wholesalePriceRate}")
//    public void setWholesalePriceRate(double value) {
//        wholesalePriceRate = value;
//    }

//    @Value("${custom.order.cancelAvailableSeconds}")
//    public void setCancelAvailableSeconds(String value) {
//        cancelAvailableSeconds = Integer.valueOf(value);
//    }

    @Value("${spring.profiles.active:}")
    public void setActiveProfile(String value) {
        activeProfile = value;
    }

    @Value("${custom.site.name}")
    public void setSiteName(String siteName) {
        AppConfig.siteName = siteName;
    }

    @Value("${custom.site.baseUrl}")
    public void setSiteBaseUrl(String siteBaseUrl) {
        AppConfig.siteBaseUrl = siteBaseUrl;
    }

    public static boolean isNotProd() {
        return isProd() == false;
    }

    public static boolean isProd() {
        return activeProfile.equals("prod");
    }

    public static boolean isNotDev() {
        return isLocal() == false;
    }

    public static boolean isLocal() {
        return activeProfile.equals("local");
    }

    public static boolean isNotTest() {
        return isLocal() == false;
    }

    public static boolean isTest() {
        return activeProfile.equals("test");
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }
}
