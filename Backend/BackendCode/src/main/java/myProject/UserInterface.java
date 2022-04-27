package myProject;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;


@Repository
public interface UserInterface extends JpaRepository<User, Integer> {


}