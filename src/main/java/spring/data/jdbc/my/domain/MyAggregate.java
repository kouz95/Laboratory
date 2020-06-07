package spring.data.jdbc.my.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

public class MyAggregate {
    @Id
    private final Long id;
    @Embedded.Nullable
    private final Name name;

    public MyAggregate(Long id, Name name) {
        this.id = id;
        this.name = name;
    }

    public MyAggregate withId(Long id) {
        return new MyAggregate(id, this.name);
    }

    public Long getId() {
        return id;
    }
}
