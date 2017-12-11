package pl.adam.puremvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.adam.puremvc.conventers.RecordRangeConventer;
import pl.adam.puremvc.services.IssueService;
import pl.adam.puremvc.services.ServletIssueService;

/**
 * Created by SkyNET on 2017-11-01.
 */

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"pl.adam.puremvc", "pl.adam.puremvc.config"})
public class PureMVCWebConfiguration extends WebMvcConfigurerAdapter{

    @Bean
    public IssueService getReport() {
        return new ServletIssueService();
    }

    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new RecordRangeConventer());
    }

}
