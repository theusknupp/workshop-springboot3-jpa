package com.estudo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.estudo.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
