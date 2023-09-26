package org.nonit.mamnon.rest;


import org.nonit.mamnon.service.DanhMucChiMamNonService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/danhmucchimamnon")
public class DanhMucChiMamNonRest {

    @Inject
    private DanhMucChiMamNonService danhMucChiMamNonService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
     public Response findAll() {
        return Response.ok(danhMucChiMamNonService.findAll()).build();
    }
}