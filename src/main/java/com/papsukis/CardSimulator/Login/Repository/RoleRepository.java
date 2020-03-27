package com.papsukis.CardSimulator.Login.Repository;


import com.papsukis.CardSimulator.Login.Models.ERole;
import com.papsukis.CardSimulator.Login.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
