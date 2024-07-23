package com.codegym.formdk.repository;

import com.codegym.formdk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {

}
