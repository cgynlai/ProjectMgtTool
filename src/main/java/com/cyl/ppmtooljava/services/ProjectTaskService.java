package com.cyl.ppmtooljava.services;

import com.cyl.ppmtooljava.domain.Backlog;
import com.cyl.ppmtooljava.domain.ProjectTask;
import com.cyl.ppmtooljava.exceptions.ProjectNotFoundException;
import com.cyl.ppmtooljava.repositories.BacklogRepository;
import com.cyl.ppmtooljava.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.PrintException;

@Service
public class ProjectTaskService {

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask){
       //Exceptions: project not found//

        try{
            //PTs to be added to a specific project, project cannot be null and BL exists
            Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);

            //set the bl to pt
            projectTask.setBacklog(backlog);



            //we want project sequence to be like this: IDPRO-1, IDPRO-2 ...
            Integer BacklogSequence = backlog.getPTSequence();
            //update bl sequence
            BacklogSequence++;

            backlog.setPTSequence(BacklogSequence);

            //add sequence to PT
            projectTask.setProjectSequence(projectIdentifier + "-" + BacklogSequence);
            projectTask.setProjectIdentifier(projectIdentifier);

            //initial priority when priority is null
            if(projectTask.getPriority()==null){
                projectTask.setPriority(3);
            }

//        if (projectTask.getPriority() == null || projectTask.getPriority() == 0) {
//            // Todo: In the future we need projectTask.getPriority() == 0 to handle the form
//            projectTask.setPriority(3);
//        }

            //intial status when status is null
            if(projectTask.getStatus()=="" || projectTask.getStatus()==null){
                projectTask.setStatus("TO_DO");
            }
            return projectTaskRepository.save(projectTask);
        }catch(Exception e){
            throw new ProjectNotFoundException("Project Not Found");
        }



    }


    public Iterable<ProjectTask> findBacklogById(String id) {
            return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);
    }
}
