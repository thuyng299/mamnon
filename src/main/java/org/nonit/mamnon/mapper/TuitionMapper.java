package org.nonit.mamnon.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.nonit.mamnon.entity.phieuthu.Tuition;
import org.nonit.mamnon.service.model.TuitionDTO;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TuitionMapper extends BaseMapper<Tuition, TuitionDTO> {

    @Override
    @Mapping(target = "invoiceId", source = "invoice.id")
    TuitionDTO toDTO(Tuition tuition);
}
