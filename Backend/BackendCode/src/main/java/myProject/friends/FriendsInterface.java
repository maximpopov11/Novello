package myProject.friends;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsInterface extends JpaRepository<Friends, FriendsKey> {
    //Friends findById(FriendsKey friend);
}
