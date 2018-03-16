package com.esuizhen.bigdata.repository.user;

import com.esuizhen.bigdata.domain.user.UUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fqc on 16/12/8.
 */
@Transactional
public interface UUserRepository extends // RevisionRepository<UUser, Long, Integer>
        JpaRepository<UUser, Long> {

}
