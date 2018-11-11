package pl.sda.githubdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(GithubProperties.class)
public class GithubDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(GithubDashboardApplication.class, args);
    }
}
