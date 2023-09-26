package org.nonit.mamnon.mapper;

import org.nonit.mamnon.entity.thuchimamnon.DanhMucChiMamNon;
import org.nonit.mamnon.service.model.DanhMucChiMamNonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DanhMucChiMamNonMapper extends BaseMapper<DanhMucChiMamNon, DanhMucChiMamNonDTO> {
}
