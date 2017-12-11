package pl.adam.puremvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.adam.puremvc.services.IssueService;
import pl.adam.puremvc.services.RootIssueService;

/**
 * Created by SkyNET on 2017-11-01.
 */

@EnableWebMvc
@Configuration
public class PureMVCAppConfiguration {

    @Bean
    public IssueService getReport() {
        return new RootIssueService();
    }

}
