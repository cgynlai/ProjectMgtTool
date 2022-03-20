package com.cyl.ppmtooljava.services;

import com.cyl.ppmtooljava.domain.Project;
import com.cyl.ppmtooljava.exceptions.ProjectIdException;
import com.cyl.ppmtooljava.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){

        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists");
        }


    }

    public Project findProjectByIdentifier(String projectId){

        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project==null){
            throw new ProjectIdException("Project ID '" + projectId + "' does not exist");
        }

        return project;


    }

    public Iterable<Project> findAllProject(){
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId);

        if(project==null){
            throw new ProjectIdException("can't find project with ID '" + projectId + "'. This project does not exist");

        }
        projectRepository.delete(project);
    }
}
