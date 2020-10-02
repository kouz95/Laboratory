package labor.n1.application;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import labor.n1.domain.Academy;
import labor.n1.domain.AcademyRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AcademyService {
    private AcademyRepository academyRepository;

    public AcademyService(AcademyRepository academyRepository) {
        this.academyRepository = academyRepository;
    }

    @Transactional(readOnly = true)
    public List<String> findAllSubjectNames(){
        return extractSubjectNames(academyRepository.findAll());
    }

    /**
     * Lazy Load를 수행하기 위해 메소드를 별도로 생성
     */
    private List<String> extractSubjectNames(List<Academy> academies){
        log.info(">>>>>>>>[모든 과목을 추출한다]<<<<<<<<<");
        log.info("Academy Size : {}", academies.size());

        return academies.stream()
                .map(a -> a.getSubjects().get(0).getName())
                .collect(Collectors.toList());
    }
}
