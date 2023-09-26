package org.nonit.mamnon.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import org.nonit.mamnon.entity.mamnon.Student;
import org.nonit.mamnon.entity.phieuthu.Invoice;
import org.nonit.mamnon.entity.phieuthu.Tuition;
import org.nonit.mamnon.service.model.InvoiceDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-26T15:30:56+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@ApplicationScoped
public class InvoiceMapperImpl implements InvoiceMapper {

    @Override
    public List<InvoiceDTO> toDTOList(List<Invoice> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<InvoiceDTO> list = new ArrayList<InvoiceDTO>( entityList.size() );
        for ( Invoice invoice : entityList ) {
            list.add( toDTO( invoice ) );
        }

        return list;
    }

    @Override
    public InvoiceDTO toDTO(Invoice invoice) {
        if ( invoice == null ) {
            return null;
        }

        InvoiceDTO.InvoiceDTOBuilder invoiceDTO = InvoiceDTO.builder();

        invoiceDTO.studentId( invoiceStudentId( invoice ) );
        invoiceDTO.firstName( invoiceStudentFirstName( invoice ) );
        invoiceDTO.lastName( invoiceStudentLastName( invoice ) );
        invoiceDTO.kDaysPrevMonth( invoice.getKDaysPrevMonth() );
        invoiceDTO.pDaysPrevMonth( invoice.getPDaysPrevMonth() );
        invoiceDTO.id( invoice.getId() );
        invoiceDTO.month( invoice.getMonth() );
        invoiceDTO.year( invoice.getYear() );
        invoiceDTO.totalAmount( invoice.getTotalAmount() );
        invoiceDTO.paymentAmount( invoice.getPaymentAmount() );
        invoiceDTO.remainAmount( invoice.getRemainAmount() );
        invoiceDTO.daysToClassCurrentMonth( invoice.getDaysToClassCurrentMonth() );
        invoiceDTO.isPaid( invoice.getIsPaid() );
        invoiceDTO.truyThuAmount( invoice.getTruyThuAmount() );
        invoiceDTO.paidDate( invoice.getPaidDate() );
        invoiceDTO.createdTime( invoice.getCreatedTime() );
        invoiceDTO.schoolId( invoice.getSchoolId() );
        invoiceDTO.stt( invoice.getStt() );
        invoiceDTO.note( invoice.getNote() );
        List<Tuition> list = invoice.getTuitions();
        if ( list != null ) {
            invoiceDTO.tuitions( new ArrayList<Tuition>( list ) );
        }

        return invoiceDTO.build();
    }

    private Integer invoiceStudentId(Invoice invoice) {
        if ( invoice == null ) {
            return null;
        }
        Student student = invoice.getStudent();
        if ( student == null ) {
            return null;
        }
        Integer id = student.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String invoiceStudentFirstName(Invoice invoice) {
        if ( invoice == null ) {
            return null;
        }
        Student student = invoice.getStudent();
        if ( student == null ) {
            return null;
        }
        String firstName = student.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String invoiceStudentLastName(Invoice invoice) {
        if ( invoice == null ) {
            return null;
        }
        Student student = invoice.getStudent();
        if ( student == null ) {
            return null;
        }
        String lastName = student.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }
}
