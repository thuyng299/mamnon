package org.nonit.mamnon.service.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassAndGradeOfStudent {

    private Integer studentId;

    private String firstName;

    private String lastName;

    private Integer clazzId;

    private Integer gradeId;

    private Integer congDoanId;
}
