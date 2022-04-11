package com.cyl.ppmtooljava.services;

import com.cyl.ppmtooljava.domain.Backlog;
import com.cyl.ppmtooljava.domain.Project;
import com.cyl.ppmtooljava.domain.ProjectTask;
import com.cyl.ppmtooljava.exceptions.ProjectNotFoundException;
import com.cyl.ppmtooljava.repositories.BacklogRepository;
import com.cyl.ppmtooljava.repositories.ProjectRepository;
import com.cyl.ppmtooljava.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.PrintException;
import java.util.List;

@Service
public class ProjectTaskService {

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    @Autowired
    private ProjectRepository projectRepository;

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

        Project project = projectRepository.findByProjectIdentifier(id);
        if(project==null){
            throw new ProjectNotFoundException("Project with ID: '" + id + "does not exist.");
        }
        return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);
    }

    public ProjectTask findPTByProjectSequence(String backlog_id, String pt_id){

       //make sure that project/backlog exists
        //Project project = projectRepository.findByProjectIdentifier(backlog_id);
        Backlog backlog = backlogRepository.findByProjectIdentifier(backlog_id);
        if(backlog==null){
            throw new ProjectNotFoundException("Project with id: '" + backlog_id + "' does not exist.");

        }

        // make sure that project task exists
        ProjectTask projectTask = projectTaskRepository.findByProjectSequence(pt_id);
        if(projectTask==null){
            throw new ProjectNotFoundException("Project Task with id: '" + pt_id + "' does not exist");
        }
        //make sure that backlog/project id in the path corresponds to the right project
        if(!projectTask.getProjectIdentifier().equals(backlog_id)){
            throw new ProjectNotFoundException("Project Task: '" + pt_id + " ' does not exist in project: '" + backlog_id + " '");
        }
        return projectTask;
    }

    public ProjectTask updateByProjectSequence(ProjectTask updatedTask, String backlog_id, String pt_id){

        //ProjectTask projectTask = projectTaskRepository.findByProjectSequence(pt_id);

        ProjectTask projectTask = findPTByProjectSequence(backlog_id, pt_id);
        projectTask = updatedTask;

        return projectTaskRepository.save(projectTask);
    }
    // update project task

    //find existing project task

    //replace it with updated task

    //save update

    public void deletePTByProjectSequence(String backlog_id, String pt_id) {

         //Backlog backlog = backlogRepository.findByProjectIdentifier(backlog_id);
        ProjectTask pt = findPTByProjectSequence(backlog_id, pt_id);
//        Backlog backlog = pt.getBacklog();
//        List<ProjectTask> projectTasks = backlog.getProjectTasks();
//       // projectTasks.remove(projectTaskRepository.findByProjectSequence(pt_id));

//        projectTasks.remove(pt);
//        backlogRepository.save(backlog);

        projectTaskRepository.delete(pt);

    }
}


