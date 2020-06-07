package spring.data.jdbc.my.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.conversion.AggregateChange;
import org.springframework.data.relational.core.mapping.event.BeforeDeleteCallback;
import org.springframework.stereotype.Component;

import spring.data.jdbc.my.domain.MyAggregate;
import spring.data.jdbc.ref.domain.RefAggregateRepository;

@Component
public class MyAggregateBeforeDeleteCallback implements BeforeDeleteCallback<MyAggregate> {
    @Autowired
    private RefAggregateRepository refAggregateRepository;

    @Override
    public MyAggregate onBeforeDelete(MyAggregate aggregate,
        AggregateChange<MyAggregate> aggregateChange) {
        refAggregateRepository.deleteByMyAggregateId(aggregate.getId());
        return aggregate;
    }
}
