package com.digital_library.repository;

import com.digital_library.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    @Query(nativeQuery = true, value = "INSERT INTO roles(id,user_id,role) VALUES (DEFAULT,:userId,'USER')")
    void addUserRole(Integer userId);

    @Query(nativeQuery = true, value = "INSERT INTO roles(id,user_id,role) VALUES (DEFAULT,:userId,'ADMIN')")
    void addAdminRole(Integer userId);


}
