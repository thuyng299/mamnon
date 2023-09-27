package org.nonit.mamnon.service;

import org.nonit.mamnon.dao.DanhMucThuDAO;
import org.nonit.mamnon.dao.InvoiceDAO;
import org.nonit.mamnon.dao.StudentDAO;
import org.nonit.mamnon.entity.congdoan.CongDoan;
import org.nonit.mamnon.entity.mamnon.Student;
import org.nonit.mamnon.entity.phieuthu.CalculationType;
import org.nonit.mamnon.entity.phieuthu.DanhMucThu;
import org.nonit.mamnon.entity.phieuthu.Invoice;
import org.nonit.mamnon.entity.phieuthu.Tuition;
import org.nonit.mamnon.mapper.InvoiceMapper;
import org.nonit.mamnon.service.model.*;

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

    public InvoiceDTO createInvoiceAndInvoiceDetail(InvoiceDetailCreate invoiceDetailCreate){

        Student student = studentDAO.getById(invoiceDetailCreate.getStudentId()).orElseThrow(RuntimeException::new);

        Integer gradeId = studentDAO.getStudentClassInfo(invoiceDetailCreate.getStudentId()).getGradeId();

        Integer schoolId = studentDAO.getCongDoanByStudentId(invoiceDetailCreate.getStudentId());

                Invoice invoice = Invoice.builder()
                .month(invoiceDetailCreate.getMonth())
                .year(invoiceDetailCreate.getYear())
                .totalAmount(0)
                .paymentAmount(invoiceDetailCreate.getTotalAmount())
//                .daysToClassCurrentMonth()
                .createdTime(LocalDateTime.now())
                .schoolId(schoolId)
                .note(invoiceDetailCreate.getNote())
                .student(student)
                .build();

        List<Tuition> tuitionList = new ArrayList<>();

        List<DanhMucThuAndDuThu> danhMucThuByStudent = danhMucThuDAO.getDanhMucThuAndDuThuOfStudent(invoiceDetailCreate.getStudentId(), gradeId);

        for (DanhMucThuAndDuThu danhMucThuAndDuThu : danhMucThuByStudent) {

            if (danhMucThuAndDuThu.getCalculationType() == CalculationType.DAILY){

            }
            Tuition tuition = Tuition.builder()
                    .invoice(invoice)
                    .name(danhMucThuAndDuThu.getName())
                    .amount(danhMucThuAndDuThu.getAmount())
                    .dailyAmount(danhMucThuAndDuThu.getCalculationType() == CalculationType.DAILY ? danhMucThuAndDuThu.getAmount() : null)
//                    .description()
                    .duthuId(danhMucThuAndDuThu.getDuthuId())
                    .isMandantory(danhMucThuAndDuThu.getIsMandantory())
                    .calculationType(danhMucThuAndDuThu.getCalculationType())
                    .isAbsentCount(danhMucThuAndDuThu.getIsAbsentCount())
                    .danhMucThuId(danhMucThuAndDuThu.getDanhmucthuId())
//                    .referencedTuition()
                    .build();

            tuitionList.add(tuition);

            invoice.setTotalAmount(tuition.getAmount());
        }



    }
}
