package spring.data.jdbc.ref.application;

import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

import spring.data.jdbc.ref.domain.RefAggregate;
import spring.data.jdbc.ref.domain.RefAggregateRepository;

@Service
public class RefAggregateService {
    private final RefAggregateRepository refAggregateRepository;

    public RefAggregateService(RefAggregateRepository refAggregateRepository) {
        this.refAggregateRepository = refAggregateRepository;
    }

    public Long create(Long myAggregateId) {
        RefAggregate persist = refAggregateRepository.save(
            new RefAggregate(null, AggregateReference.to(myAggregateId)));
        return persist.getId();
    }

    public RefAggregate findById(Long id) {
        return refAggregateRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("not exist"));
    }
}
