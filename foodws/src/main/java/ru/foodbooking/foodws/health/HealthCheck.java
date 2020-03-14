package ru.foodbooking.foodws.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

@Service
public class HealthCheck implements HealthIndicator {

    @Override
    public Health health() {
        int errorCode = check();
        Health health;
        if (errorCode != 0)
            health = Health.down().withDetail("Error Code:",errorCode).build();
        else
            health = Health.up().build();
        return health;
    }

    private int check(){
        return 0;
    }
}
