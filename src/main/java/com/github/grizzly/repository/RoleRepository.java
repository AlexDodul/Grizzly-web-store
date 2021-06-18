package com.github.grizzly.repository;

import com.github.grizzly.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findById(long id);

    Optional<Role> findByRole(Role.Values role);

    List<Role> findAllByUsers_Id(long users_id);

}
