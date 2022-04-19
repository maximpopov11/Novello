package myProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface FriendsInterface extends JpaRepository<Friends, Integer> {
    Friends findById(int id);

    @Transactional
    void deleteById(int id);
}
