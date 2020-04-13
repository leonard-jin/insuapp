package com.therich.apps.dataproviders.recommends.persistence.repository;

import com.therich.apps.dataproviders.recommends.persistence.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kh.jin on 2020. 3. 5.
 */
@Repository
public interface RecommendJpaRepository extends JpaRepository<Recommend, Long> {
    Integer countByParentMemberNo(Long parentMemberNo);
    Recommend findByParentMemberNo(Long parentMemberNo);
}
