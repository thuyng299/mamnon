package org.nonit.mamnon.service.model;

import lombok.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceDetailOfStudent {

    private Integer studentId;

    private String studentName;

    private String month;

    private Long invoiceId;

    private Double totalAmount;

    private List<InvoiceDetail> invoiceDetailList;
}
