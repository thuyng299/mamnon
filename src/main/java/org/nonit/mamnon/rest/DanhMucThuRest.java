package org.nonit.mamnon.rest;

import org.nonit.mamnon.service.DanhMucThuService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/danhmucthu")
public class DanhMucThuRest {

    @Inject
    private DanhMucThuService danhMucThuService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllDanhMucThu(){
        return Response.ok(danhMucThuService.getAllDanhMucThu()).build();
    }

    @GET
    @Path("/danhmucthu-of-student")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getDanhMucThuAndDuThuOfStudent(@QueryParam("studentId") Integer studentId,
                                                   @QueryParam("gradeId") Integer gradeId){
        return Response.ok(danhMucThuService.getDanhMucThuAndDuThuOfStudent(studentId, gradeId)).build();
    }
}
