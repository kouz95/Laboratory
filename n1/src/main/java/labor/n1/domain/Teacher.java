package labor.n1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Teacher(String name) {
        this.name = name;
    }
}
