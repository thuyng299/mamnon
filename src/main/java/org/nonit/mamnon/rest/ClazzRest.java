package org.nonit.mamnon.rest;

import org.nonit.mamnon.service.ClazzService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/clazz")
public class ClazzRest {

    @Inject
    private ClazzService clazzService;

    @GET
    @Path("/total-class-grade-in-academic-year")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getClassListOfGradeInAcademicYear(@QueryParam("congDoanId") Integer congDoanId,
                                                      @QueryParam("gradeId") Integer gradeId,
                                                      @QueryParam("academicYear") String academicYear)
    {
        return Response.ok(clazzService.getClassListOfGradeInAcademicYear(congDoanId, gradeId, academicYear)).build();
    }

}
