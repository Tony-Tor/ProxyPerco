package net.proselyte.jwtappdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
public class StudentData {
    private String last_name;
    private String first_name;
    private String middle_name;
    private String division;
    private String position;
    private String tabel_number;
    private String begin_datetime;
    private String end_datetime;
    private List<Long> access_template;
    private String hiring_date;

    @Override
    public String toString() {
        return "StudentData{" +
                "last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", division='" + division + '\'' +
                ", position='" + position + '\'' +
                ", tabel_number='" + tabel_number + '\'' +
                ", begin_datetime='" + begin_datetime + '\'' +
                ", end_datetime='" + end_datetime + '\'' +
                ", access_template=" + access_template +
                ", hiring_date='" + hiring_date + '\'' +
                '}';
    }
}
