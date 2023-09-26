package org.nonit.mamnon.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;
import org.nonit.mamnon.entity.phieuthu.Tuition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDTO {

    private Long id;

    private int month;

    private int year;

    private Integer totalAmount;

    private Integer paymentAmount;

    private Integer remainAmount;

    private Integer kDaysPrevMonth;

    private Integer pDaysPrevMonth;

    private Integer daysToClassCurrentMonth;

    private Boolean isPaid;

    private Integer truyThuAmount;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDate paidDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdTime;

    private Integer schoolId;

    private List<Tuition> tuitions;

    private Integer stt;

    private String note;

    private Integer studentId;

    private String firstName;

    private String lastName;
}
