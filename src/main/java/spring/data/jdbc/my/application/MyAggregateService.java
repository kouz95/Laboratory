package spring.data.jdbc.my.application;

import org.springframework.stereotype.Service;

import spring.data.jdbc.my.domain.MyAggregate;
import spring.data.jdbc.my.domain.MyAggregateRepository;
import spring.data.jdbc.my.domain.Name;

@Service
public class MyAggregateService {
    private final MyAggregateRepository myAggregateRepository;

    public MyAggregateService(MyAggregateRepository myAggregateRepository) {
        this.myAggregateRepository = myAggregateRepository;
    }

    public Long create(String name) {
        MyAggregate persist = myAggregateRepository.save(new MyAggregate(null, new Name(name)));
        return persist.getId();
    }

    public void delete(Long id) {
        MyAggregate myAggregate = myAggregateRepository.findById(id)
            .orElseThrow(RuntimeException::new);
        myAggregateRepository.delete(myAggregate);
    }
}
