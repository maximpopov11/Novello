package myProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationInterface extends JpaRepository<Evaluation, EvaluationKey> {

}
