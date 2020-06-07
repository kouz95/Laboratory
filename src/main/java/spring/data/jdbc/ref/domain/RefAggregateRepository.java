package spring.data.jdbc.ref.domain;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RefAggregateRepository extends CrudRepository<RefAggregate, Long> {
    @Modifying
    @Query("delete from ref_aggregate where my_aggregate_id = :myAggregateId")
    void deleteByMyAggregateId(@Param("myAggregateId") Long myAggregateId);
}
