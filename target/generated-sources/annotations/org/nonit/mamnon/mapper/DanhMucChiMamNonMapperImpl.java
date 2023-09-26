package org.nonit.mamnon.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import org.nonit.mamnon.entity.thuchimamnon.DanhMucChiMamNon;
import org.nonit.mamnon.service.model.DanhMucChiMamNonDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-26T15:30:56+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@ApplicationScoped
public class DanhMucChiMamNonMapperImpl implements DanhMucChiMamNonMapper {

    @Override
    public DanhMucChiMamNonDTO toDTO(DanhMucChiMamNon entity) {
        if ( entity == null ) {
            return null;
        }

        DanhMucChiMamNonDTO.DanhMucChiMamNonDTOBuilder danhMucChiMamNonDTO = DanhMucChiMamNonDTO.builder();

        if ( entity.getId() != null ) {
            danhMucChiMamNonDTO.id( entity.getId().longValue() );
        }
        danhMucChiMamNonDTO.name( entity.getName() );
        danhMucChiMamNonDTO.code( entity.getCode() );

        return danhMucChiMamNonDTO.build();
    }

    @Override
    public List<DanhMucChiMamNonDTO> toDTOList(List<DanhMucChiMamNon> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DanhMucChiMamNonDTO> list = new ArrayList<DanhMucChiMamNonDTO>( entityList.size() );
        for ( DanhMucChiMamNon danhMucChiMamNon : entityList ) {
            list.add( toDTO( danhMucChiMamNon ) );
        }

        return list;
    }
}
