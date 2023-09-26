package org.nonit.mamnon.service;

import org.nonit.mamnon.dao.InvoiceDAO;
import org.nonit.mamnon.entity.phieuthu.Invoice;
import org.nonit.mamnon.mapper.InvoiceMapper;
import org.nonit.mamnon.service.model.InvoiceDTO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class InvoiceService {

    @Inject
    private InvoiceDAO invoiceDAO;

    @Inject
    private InvoiceMapper invoiceMapper;

    public InvoiceDTO getInvoiceListOfStudent(Integer studentId, int month, int year){
        Invoice invoice = invoiceDAO.getInvoiceListOfStudent(studentId, month, year);
        return invoiceMapper.toDTO(invoice);
    }
}
