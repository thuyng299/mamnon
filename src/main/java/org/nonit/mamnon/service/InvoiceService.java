package org.nonit.mamnon.service;

import org.nonit.mamnon.dao.DanhMucThuDAO;
import org.nonit.mamnon.dao.InvoiceDAO;
import org.nonit.mamnon.dao.StudentDAO;
import org.nonit.mamnon.entity.congdoan.CongDoan;
import org.nonit.mamnon.entity.mamnon.Student;
import org.nonit.mamnon.entity.phieuthu.DanhMucThu;
import org.nonit.mamnon.entity.phieuthu.Invoice;
import org.nonit.mamnon.entity.phieuthu.Tuition;
import org.nonit.mamnon.mapper.InvoiceMapper;
import org.nonit.mamnon.service.model.InvoiceDTO;
import org.nonit.mamnon.service.model.InvoiceDetailCreate;
import org.nonit.mamnon.service.model.TuitionDTO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Stateless
public class InvoiceService {

    @Inject
    private InvoiceDAO invoiceDAO;

    @Inject
    private StudentDAO studentDAO;

    @Inject
    private DanhMucThuDAO danhMucThuDAO;

    @Inject
    private InvoiceMapper invoiceMapper;

    public InvoiceDTO getInvoiceListOfStudent(Integer studentId, int month, int year){
        Invoice invoice = invoiceDAO.getInvoiceListOfStudent(studentId, month, year);
        return invoiceMapper.toDTO(invoice);
    }
//
//    public InvoiceDTO createInvoiceAndInvoiceDetail(InvoiceDetailCreate invoiceDetailCreate){
//
//        Student student = studentDAO.getById(invoiceDetailCreate.getStudentId()).orElseThrow(RuntimeException::new);
//
//        Integer schoolId = studentDAO.getCongDoanByStudentId(invoiceDetailCreate.getStudentId());
//
//                Invoice invoice = Invoice.builder()
//                .month(invoiceDetailCreate.getMonth())
//                .year(invoiceDetailCreate.getYear())
//                .totalAmount()
//                .paymentAmount(invoiceDetailCreate.getTotalAmount())
//                .daysToClassCurrentMonth()
//                .createdTime(LocalDateTime.now())
//                .schoolId(schoolId)
//                .note(invoiceDetailCreate.getNote())
//                .student(student)
//                .build();
//
//        Map<CongDoan, List<DanhMucThu>> danhMucThuMapByCongDoan = danhMucThuDAO.getAllDanhMucThuAndDuThu().stream()
//                .filter(DanhMucThu::isActive)
//                .filter(d -> d.getCongdoan().getId().equals(schoolId))
//                .collect(Collectors.groupingBy(DanhMucThu::getCongdoan));
//
//        List<Tuition> tuitionList = new ArrayList<>();
//
//        for (TuitionDTO t: invoiceDetailCreate.getTuitionList()){
//            List<DanhMucThu> danhMucThuList = danhMucThuMapByCongDoan.entrySet()
//                    .stream()
//                    .flatMap(entry -> entry.getValue().stream()
//                            .map(danhMucThu -> {
//                                Tuition tuition = new Tuition();
//
//                                tuition.setInvoice(invoice);
//                                tuition.setName(danhMucThu.getName());
//                                tuition.setAmount();
//                                tuition.setDailyAmount();
//                                tuition.setDuthuId();
//                                tuition.setIsMandantory();
//                                tuition.setCalculationType();
//                                tuition.setIsAbsentCount();
//                                tuition.setReferencedTuition();
//                                tuition.setDescription(t.getDescription().trim());
//                            })
//                    )
//                    .collect(Collectors.toList());
//        }
//
//
//
//
//
//    }
}
