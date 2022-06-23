package com.cyl.ppmtooljava.services;

import com.cyl.ppmtooljava.domain.Backlog;
import com.cyl.ppmtooljava.domain.Project;
import com.cyl.ppmtooljava.domain.User;
import com.cyl.ppmtooljava.exceptions.ProjectIdException;
import com.cyl.ppmtooljava.exceptions.ProjectNotFoundException;
import com.cyl.ppmtooljava.repositories.BacklogRepository;
import com.cyl.ppmtooljava.repositories.ProjectRepository;
import com.cyl.ppmtooljava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BacklogRepository backlogRepository;

    public Project saveOrUpdateProject(Project project, String name){

        try{
            User user = userRepository.findByUsername(name);
            project.setUser(user);
            project.setProjectLeader(user.getUsername());
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());

            if(project.getId()==null){
                Backlog backlog = new Backlog();
                project.setBacklog(backlog);
                backlog.setProject(project);
                backlog.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            }

            if(project.getId()!=null){
              project.setBacklog(backlogRepository.findByProjectIdentifier(project.getProjectIdentifier().toUpperCase()));
            }

            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists");
        }


    }

    public Project findProjectByIdentifier(String projectId, String username){

        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project==null){
            throw new ProjectIdException("Project ID '" + projectId + "' does not exist");
        }

        if(!project.getProjectLeader().equals(username)){
            throw new ProjectNotFoundException("project not found in your account");
        }

        return project;


    }

    public Iterable<Project> findAllProject(String username){
        return projectRepository.findAllByProjectLeader(username);
    }

    public void deleteProjectByIdentifier(String projectId, String username){
        projectRepository.delete(findProjectByIdentifier(projectId, username));
    }
}

//test git