package org.nonit.mamnon.rest;

import org.nonit.mamnon.service.TuitionService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/tuitions")
public class TuitionRest {

    @Inject
    private TuitionService tuitionService;

    @GET
    @Path("/detail-of-invoice")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getInvoiceDetailListByInvoice(@QueryParam("invoiceId") Long invoiceId){
        return Response.ok(tuitionService.getInvoiceDetailListByInvoice(invoiceId)).build();
    }

    @GET
    @Path("/invoice-detail-of-student-in-month")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getInvoiceDetailOfStudent(@QueryParam("studentId") Integer studentId,
                                              @QueryParam("month") int month,
                                              @QueryParam("year") int year){
        return Response.ok(tuitionService.getInvoiceDetailOfStudent(studentId, month, year)).build();
    }
}
