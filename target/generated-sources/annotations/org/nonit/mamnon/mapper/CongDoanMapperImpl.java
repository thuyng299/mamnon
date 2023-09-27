package org.nonit.mamnon.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import org.nonit.mamnon.entity.congdoan.CongDoan;
import org.nonit.mamnon.service.model.CongDoanDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-27T14:06:04+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@ApplicationScoped
public class CongDoanMapperImpl implements CongDoanMapper {

    @Override
    public CongDoanDTO toDTO(CongDoan entity) {
        if ( entity == null ) {
            return null;
        }

        CongDoanDTO.CongDoanDTOBuilder congDoanDTO = CongDoanDTO.builder();

        congDoanDTO.id( entity.getId() );
        congDoanDTO.name( entity.getName() );
        congDoanDTO.address( entity.getAddress() );
        congDoanDTO.district( entity.getDistrict() );
        congDoanDTO.city( entity.getCity() );
        congDoanDTO.principalName( entity.getPrincipalName() );
        congDoanDTO.accountantName( entity.getAccountantName() );
        congDoanDTO.congDoanName( entity.getCongDoanName() );
        congDoanDTO.paymentDueDate( entity.getPaymentDueDate() );
        congDoanDTO.paymentSentDate( entity.getPaymentSentDate() );
        congDoanDTO.createdDate( entity.getCreatedDate() );
        congDoanDTO.updatedDate( entity.getUpdatedDate() );

        return congDoanDTO.build();
    }

    @Override
    public List<CongDoanDTO> toDTOList(List<CongDoan> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CongDoanDTO> list = new ArrayList<CongDoanDTO>( entityList.size() );
        for ( CongDoan congDoan : entityList ) {
            list.add( toDTO( congDoan ) );
        }

        return list;
    }
}
