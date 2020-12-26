package com.alexcosta.seguranca.repositories;

import com.alexcosta.seguranca.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    
}
