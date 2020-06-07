package spring.data.jdbc.ref.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import spring.data.jdbc.my.domain.MyAggregate;

public class RefAggregate {
    @Id
    private final Long id;
    private final AggregateReference<MyAggregate, Long> myAggregateId;

    public RefAggregate(Long id, AggregateReference<MyAggregate, Long> myAggregateId) {
        this.id = id;
        this.myAggregateId = myAggregateId;
    }

    public RefAggregate withId(Long id) {
        return new RefAggregate(id, this.myAggregateId);
    }

    public Long getId() {
        return id;
    }

    public AggregateReference<MyAggregate, Long> getMyAggregateId() {
        return myAggregateId;
    }
}
