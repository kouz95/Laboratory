package spring.data.jdbc.my.application;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.context.annotation.Import;

import spring.data.jdbc.my.domain.MyAggregate;
import spring.data.jdbc.my.infra.MyAggregateBeforeDeleteListener;
import spring.data.jdbc.ref.application.RefAggregateService;
import spring.data.jdbc.ref.domain.RefAggregate;

@DataJdbcTest
@Import({MyAggregateService.class, RefAggregateService.class, MyAggregateBeforeDeleteListener.class})
class MyAggregateServiceTest {
    @Autowired
    private MyAggregateService myAggregateService;

    @Autowired
    private RefAggregateService refAggregateService;

    @Test
    void test() {
        Long myAggregateId = myAggregateService.create("test");
        Long refAggregateId = refAggregateService.create(myAggregateId);
        RefAggregate refAggregate = refAggregateService.findById(refAggregateId);
        assertThat(refAggregate.getId()).isNotNull();

        myAggregateService.delete(myAggregateId);

        assertThatThrownBy(() -> refAggregateService.findById(refAggregateId))
        .isInstanceOf(RuntimeException.class)
        .hasMessage("not exist");
    }

    @Test
    void queryLookup() {
        myAggregateService.create("test");
        MyAggregate test = myAggregateService.findByName("test");
        assertThat(test).isNotNull();
    }
}