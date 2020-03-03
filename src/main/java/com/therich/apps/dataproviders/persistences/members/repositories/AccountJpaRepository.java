package com.therich.apps.dataproviders.persistences.members.repositories;

import com.therich.apps.dataproviders.persistences.members.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kh.jin on 2020. 2. 15.
 */
@Repository
public interface AccountJpaRepository extends JpaRepository<Account, String> {
}
