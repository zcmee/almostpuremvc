package pl.adam.puremvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.adam.puremvc.pl.adam.puremvc.services.IssueService;
import pl.adam.puremvc.pl.adam.puremvc.services.ServletIssueService;

/**
 * Created by SkyNET on 2017-11-01.
 */

@EnableWebMvc
@Configuration
@ComponentScan("pl.adam.puremvc.controllers")
public class PureMVCWebConfiguration {

    @Bean
    public IssueService getReport() {
        return new ServletIssueService();
    }

}
