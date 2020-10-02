package spring.data.jdbc.my.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface MyAggregateRepository extends CrudRepository<MyAggregate, Long> {
    Optional<MyAggregate> findByName(Name name);
}
