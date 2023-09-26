package org.nonit.mamnon.service.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassAndStudentList {

    private Integer classId;

    private String className;

    private Long totalStudents;

    private Integer gradeId;

    private String gradeName;

    private String academicYear;
}
