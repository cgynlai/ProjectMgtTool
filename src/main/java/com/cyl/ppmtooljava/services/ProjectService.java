package com.cyl.ppmtooljava.services;

import com.cyl.ppmtooljava.domain.Project;
import com.cyl.ppmtooljava.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){

        return projectRepository.save(project);
    }

}
