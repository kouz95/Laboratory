package spring.data.jdbc.my.infra;

import java.util.Objects;

import org.springframework.data.relational.core.mapping.event.AbstractRelationalEventListener;
import org.springframework.data.relational.core.mapping.event.BeforeDeleteEvent;
import org.springframework.stereotype.Component;

import spring.data.jdbc.my.domain.MyAggregate;
import spring.data.jdbc.ref.domain.RefAggregateRepository;

@Component
public class MyAggregateBeforeDeleteListener extends AbstractRelationalEventListener<MyAggregate> {
    private final RefAggregateRepository refAggregateRepository;

    public MyAggregateBeforeDeleteListener(RefAggregateRepository refAggregateRepository) {
        this.refAggregateRepository = refAggregateRepository;
    }

    @Override
    protected void onBeforeDelete(BeforeDeleteEvent<MyAggregate> event) {
        refAggregateRepository.deleteByMyAggregateId(
            Objects.requireNonNull(event.getEntity()).getId());
    }
}
