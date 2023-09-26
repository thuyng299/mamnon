package org.nonit.mamnon.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.nonit.mamnon.entity.congdoan.CongDoan;
import org.nonit.mamnon.service.model.CongDoanDTO;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CongDoanMapper extends BaseMapper<CongDoan, CongDoanDTO>{
}
