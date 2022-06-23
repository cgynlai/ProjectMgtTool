package com.cyl.ppmtooljava.repositories;

import com.cyl.ppmtooljava.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
//    @Override
//    Iterable<Project> findAllById(Iterable<Long> longs);

    Project findByProjectIdentifier(String projectId);

//    @Override
//    Iterable<Project> findAll();

    Iterable<Project> findAllByProjectLeader(String username);


//    @Override
//    void delete(Project entity);


}
