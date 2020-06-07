package spring.data.jdbc.my.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.BeforeDeleteCallback;

import spring.data.jdbc.my.domain.MyAggregate;

@Configuration
public class EntityCallbackConfiguration {
    @Bean
    BeforeDeleteCallback<MyAggregate> beforeDeleteCallback() {
        return new MyAggregateBeforeDeleteCallback();
    }
}
