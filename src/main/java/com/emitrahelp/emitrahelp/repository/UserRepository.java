package com.emitrahelp.emitrahelp.repository;

import com.emitrahelp.emitrahelp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findFirstByEmail(String email);
//    User findByEmail(String email);
}
