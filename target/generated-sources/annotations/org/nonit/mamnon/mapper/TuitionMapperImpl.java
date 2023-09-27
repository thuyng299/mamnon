package org.nonit.mamnon.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import org.nonit.mamnon.entity.phieuthu.Invoice;
import org.nonit.mamnon.entity.phieuthu.Tuition;
import org.nonit.mamnon.service.model.TuitionDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-27T14:06:04+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@ApplicationScoped
public class TuitionMapperImpl implements TuitionMapper {

    @Override
    public List<TuitionDTO> toDTOList(List<Tuition> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TuitionDTO> list = new ArrayList<TuitionDTO>( entityList.size() );
        for ( Tuition tuition : entityList ) {
            list.add( toDTO( tuition ) );
        }

        return list;
    }

    @Override
    public TuitionDTO toDTO(Tuition tuition) {
        if ( tuition == null ) {
            return null;
        }

        TuitionDTO.TuitionDTOBuilder tuitionDTO = TuitionDTO.builder();

        tuitionDTO.invoiceId( tuitionInvoiceId( tuition ) );
        tuitionDTO.uuid( tuition.getUuid() );
        tuitionDTO.name( tuition.getName() );
        tuitionDTO.amount( tuition.getAmount() );
        tuitionDTO.dailyAmount( tuition.getDailyAmount() );
        tuitionDTO.description( tuition.getDescription() );
        tuitionDTO.duthuId( tuition.getDuthuId() );
        tuitionDTO.isMandantory( tuition.getIsMandantory() );
        tuitionDTO.calculationType( tuition.getCalculationType() );
        tuitionDTO.isAbsentCount( tuition.getIsAbsentCount() );
        tuitionDTO.remainingAmount( tuition.getRemainingAmount() );
        tuitionDTO.subjectRegistrationDate( tuition.getSubjectRegistrationDate() );
        tuitionDTO.danhMucThuId( tuition.getDanhMucThuId() );

        return tuitionDTO.build();
    }

    private Long tuitionInvoiceId(Tuition tuition) {
        if ( tuition == null ) {
            return null;
        }
        Invoice invoice = tuition.getInvoice();
        if ( invoice == null ) {
            return null;
        }
        Long id = invoice.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
