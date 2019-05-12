package com.revature.repository;

import com.revature.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author William Gentry
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findUserByUsername(String username);
}
