package com.esuizhen.bigdata.repository.user;

import com.esuizhen.bigdata.domain.mergebak.user.UUserMergeBak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fqc on 16/12/22.
 */
@RepositoryRestResource
@Transactional
public interface UUserMergeBakRepository extends //RevisionRepository<UUserMergeBak, Long, Integer>,
        JpaRepository<UUserMergeBak, Long> {

    List<UUserMergeBak> findByUserId(Long userId);

}
