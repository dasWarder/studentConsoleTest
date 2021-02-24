package config;

import model.Tester;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.populate.PopulateService;
import service.testing.TestService;

@Configuration
public class Config {

    @Bean(name = "tester")
    public Tester getTest() {
        return new Tester();
    }

    @Bean(name = "populate")
    public PopulateService getPopulateService() {
        return new PopulateService(getTest());
    }

    @Bean(name = "testing")
    public TestService getTestService() {
        return new TestService(getTest());
    }
}
