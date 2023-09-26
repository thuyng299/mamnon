package org.nonit.mamnon.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;
import org.nonit.mamnon.entity.phieuthu.CalculationType;
import org.nonit.mamnon.entity.phieuthu.Invoice;
import org.nonit.mamnon.entity.phieuthu.Tuition;
import org.nonit.mamnon.entity.thuchimamnon.DanhMucThuMamNon;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceDetailDTO {

    private String name;
    private Integer amount;
    private Integer dailyAmount;
    private String description;
    private Long duthuId;
    private Boolean isMandantory;
    @Enumerated(EnumType.STRING)
    private CalculationType calculationType;

    private Boolean isAbsentCount;

    private Integer danhmucthuId;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime subjectRegistrationDate;

    private Long danhMucThuId;
}
