package org.nonit.mamnon.service;

import org.nonit.mamnon.dao.InvoiceDAO;
import org.nonit.mamnon.dao.TuitionDAO;
import org.nonit.mamnon.entity.phieuthu.Invoice;
import org.nonit.mamnon.entity.phieuthu.Tuition;
import org.nonit.mamnon.mapper.TuitionMapper;
import org.nonit.mamnon.service.model.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Stateless
public class TuitionService {

    @Inject
    private TuitionDAO tuitionDAO;

    @Inject
    private InvoiceDAO invoiceDAO;

    @Inject
    private TuitionMapper tuitionMapper;


    public List<TuitionDTO> getInvoiceDetailListByInvoice(Long invoiceId) {
        List<Tuition> tuitionList = tuitionDAO.getInvoiceDetailListByInvoice(invoiceId);
        return tuitionMapper.toDTOList(tuitionList);

    }

    public InvoiceDetailOfStudent getInvoiceDetailOfStudent(Integer studentId, int month, int year) {

        Invoice monthlyInvoiceOfStudent = invoiceDAO.getInvoiceListOfStudent(studentId, month, year);

        List<Tuition> tuitionList = tuitionDAO.getInvoiceDetailListByInvoice(monthlyInvoiceOfStudent.getId());

        List<InvoiceDetail> invoiceDetailList = tuitionList.stream()
                .map(t -> InvoiceDetail.builder()
                        .name(t.getName())
                        .description(t.getDescription())
                        .amount(t.getAmount())
                        .build())
                .collect(Collectors.toList());

        return InvoiceDetailOfStudent.builder()
                .studentId(studentId)
                .month(month + "-" + year)
                .studentName(monthlyInvoiceOfStudent.getStudent().getFullName())
                .invoiceId(monthlyInvoiceOfStudent.getId())
                .totalAmount((double)monthlyInvoiceOfStudent.getTotalAmount())
                .invoiceDetailList(invoiceDetailList)
                .build();
    }

//    public InvoiceDetailOfStudent getInvoiceDetailOfStudent(Integer studentId, int month, int year){
//
//        Invoice monthlyInvoiceOfStudent = invoiceDAO.getInvoiceListOfStudent(studentId, month, year);
//
//        Map<Invoice, List<Tuition>> invoiceDetailMapByInvoice = tuitionDAO.getInvoiceDetailList().stream()
//                .filter(i -> i.getInvoice().getId().equals(monthlyInvoiceOfStudent.getId()))
//                .collect(Collectors.groupingBy(Tuition::getInvoice));
//
//        List<InvoiceDetail> invoiceDetailList = invoiceDetailMapByInvoice.entrySet()
//                .stream()
//                .flatMap(entry -> entry.getValue().stream()
//                        .map(tuition -> {
//                            InvoiceDetail invoiceDetail = new InvoiceDetail();
//                            invoiceDetail.setName(tuition.getName());
//                            invoiceDetail.setDescription(tuition.getDescription());
//                            invoiceDetail.setAmount(tuition.getAmount());
//                            return invoiceDetail;
//                        })
//                )
//                .collect(Collectors.toList());
//
//        return InvoiceDetailOfStudent.builder()
//                .studentId(studentId)
//                .month(month + "-" + year)
//                .studentName(monthlyInvoiceOfStudent.getStudent().getFullName())
//                .totalAmount((double)monthlyInvoiceOfStudent.getTotalAmount())
//                .invoiceDetailList(invoiceDetailList)
//                .build();
//    }
}
