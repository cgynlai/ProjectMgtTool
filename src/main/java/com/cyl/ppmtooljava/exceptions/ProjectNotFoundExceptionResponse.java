package com.cyl.ppmtooljava.exceptions;

/**
 * @Auther: cyl
 * @Date: 31/3/2022 - 03 - 2022 - 12:31 PM
 * @Description: com.cyl.ppmtooljava.exceptions
 * @version: 1.0
 */
public class ProjectNotFoundExceptionResponse {

    private String ProjectNotFound;

    public ProjectNotFoundExceptionResponse(String projectNotFound) {
        ProjectNotFound = projectNotFound;
    }

    public String getProjectNotFound() {
        return ProjectNotFound;
    }

    public void setProjectNotFound(String projectNotFound) {
        ProjectNotFound = projectNotFound;
    }
}
