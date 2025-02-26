package net.diyotech.student_management_system.model;

import lombok.*;
import net.diyotech.student_management_system.service.FirstService;

@Getter
@Setter
@ToString
@Builder
public class Project {
    private String  name;
    private Double budget;
    private Float months;
}
