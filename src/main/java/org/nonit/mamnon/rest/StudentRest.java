package org.nonit.mamnon.rest;

import org.nonit.mamnon.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/students")
public class StudentRest {
    @Inject
    private StudentService studentService;

    @GET
    @Path("/student-class-info")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getStudentClassInfo(@QueryParam("studentId") Integer studentId){
        return Response.ok(studentService.getStudentClassInfo(studentId)).build();
    }
}
