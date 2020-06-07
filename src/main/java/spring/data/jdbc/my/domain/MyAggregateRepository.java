package spring.data.jdbc.my.domain;

import org.springframework.data.repository.CrudRepository;

public interface MyAggregateRepository extends CrudRepository<MyAggregate, Long> {
}
