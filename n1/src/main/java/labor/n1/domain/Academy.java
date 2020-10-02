package labor.n1.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Academy {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "academy_id")
    private List<Subject> subjects = new ArrayList<>();

    @Builder
    public Academy(String name, List<Subject> subjects) {
        this.name = name;
        if (subjects != null) {
            this.subjects = subjects;
        }
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
        subject.updateAcademy(this);
    }
}
