package myProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface FriendsInterface extends JpaRepository<Friends, FriendsKey> {
    //Friends findById(FriendsKey friend);
}
