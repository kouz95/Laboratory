package spring.data.jdbc.my.application;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;

import spring.data.jdbc.ref.application.RefAggregateService;
import spring.data.jdbc.ref.domain.RefAggregate;

@SpringBootTest
class MyAggregateServiceTest {
    @Autowired
    private MyAggregateService myAggregateService;

    @Autowired
    private RefAggregateService refAggregateService;

    @Test
    void name() {
        Long myAggregateId = myAggregateService.create("test");
        Long refAggregateId = refAggregateService.create(myAggregateId);
        RefAggregate refAggregate = refAggregateService.findById(refAggregateId);
        assertThat(refAggregate.getId()).isNotNull();

        myAggregateService.delete(myAggregateId);
        assertThatThrownBy(() -> refAggregateService.findById(refAggregateId))
        .isInstanceOf(RuntimeException.class)
        .hasMessage("not exist");
    }
}