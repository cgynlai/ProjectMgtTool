package com.cyl.ppmtooljava.repositories;

import com.cyl.ppmtooljava.domain.Backlog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends CrudRepository<Backlog, Long> {

   Backlog findByProjectIdentifier(String identifier);
}
