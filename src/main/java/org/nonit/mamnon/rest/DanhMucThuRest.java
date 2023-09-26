package org.nonit.mamnon.rest;

import org.nonit.mamnon.service.DanhMucThuService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}
