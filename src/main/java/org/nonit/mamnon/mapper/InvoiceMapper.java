package org.nonit.mamnon.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.nonit.mamnon.entity.phieuthu.Invoice;
import org.nonit.mamnon.service.model.InvoiceDTO;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface InvoiceMapper extends BaseMapper<Invoice, InvoiceDTO>{

    @Override
    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "firstName", source = "student.firstName")
    @Mapping(target = "lastName", source = "student.lastName")
    @Mapping(target = "kDaysPrevMonth", source = "KDaysPrevMonth")
    @Mapping(target = "pDaysPrevMonth", source = "PDaysPrevMonth")
    InvoiceDTO toDTO(Invoice invoice);
}
