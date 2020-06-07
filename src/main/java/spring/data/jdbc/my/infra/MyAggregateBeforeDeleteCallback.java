package spring.data.jdbc.my.infra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.conversion.AggregateChange;
import org.springframework.data.relational.core.conversion.DbAction;
import org.springframework.data.relational.core.mapping.event.BeforeDeleteCallback;
import org.springframework.stereotype.Component;

import spring.data.jdbc.my.domain.MyAggregate;
import spring.data.jdbc.ref.domain.RefAggregate;
import spring.data.jdbc.ref.domain.RefAggregateRepository;

public class MyAggregateBeforeDeleteCallback implements BeforeDeleteCallback<MyAggregate> {

    @Override
    public MyAggregate onBeforeDelete(MyAggregate aggregate, AggregateChange<MyAggregate> aggregateChange) {
        return aggregate;
    }
}
