package pl.sda.githubdashboard;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pl.sda.githubdashboard.github.GithubClient;
import pl.sda.githubdashboard.github.RepositoryEvent;

@Component
public class GithubHealthIndicator implements HealthIndicator {
    private final GithubClient githubClient;

    public GithubHealthIndicator(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    @Override
    public Health health() {
        try {
            ResponseEntity<RepositoryEvent[]> response = this.githubClient
                    .fetchEvents("spring-projects", "spring-boot");
            if (response.getStatusCode().is2xxSuccessful()) {
                return Health.up().build();
            } else {
                return Health.down().build();
            }
        } catch (Exception e) {
            return Health.down(e).build();
        }
    }
}
