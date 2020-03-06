package com.therich.apps.dataproviders.persistences.recommend.repositories;

import com.therich.apps.dataproviders.persistences.recommend.entities.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kh.jin on 2020. 3. 5.
 */
@Repository
public interface RecommendJpaRepository extends JpaRepository<Recommend, Recommend.PK> {
    Integer countById_ParentMemberNo(Long parentMemberNo);
}
