package com.therich.apps.core.members.persistences.repositories;

import com.therich.apps.core.members.persistences.entities.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kh.jin on 2020. 2. 15.
 */
@Repository
public interface AuthJpaRepository extends JpaRepository<Auth, String> {
}
