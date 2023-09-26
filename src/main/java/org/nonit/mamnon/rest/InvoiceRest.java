package org.nonit.mamnon.rest;

import org.nonit.mamnon.service.InvoiceService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/invoices")
public class InvoiceRest {

    @Inject
    private InvoiceService invoiceService;

    @GET
    @Path("/invoice-of-student-in-month")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getInvoiceListOfStudent(@QueryParam("studentId") Integer studentId,
                                            @QueryParam("month") int month,
                                            @QueryParam("year") int year){
        return Response.ok(invoiceService.getInvoiceListOfStudent(studentId, month, year)).build();
    }
}
