package spring.data.jdbc.ref.domain;

import java.util.List;

import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import spring.data.jdbc.my.domain.MyAggregate;

public interface RefAggregateRepository extends CrudRepository<RefAggregate, Long> {

    @Query("select * from ref_aggregate where my_aggregate_id = :myAggregateId")
    List<RefAggregate> findAllByMyAggregateId(@Param("myAggregateId") AggregateReference<MyAggregate, Long> myAggregateId);
}
