package net.proselyte.jwtappdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class StudentDataWithPhoto extends StudentData{
    private String photo;

    @Override
    public String toString() {
        return super.toString()+"StudentDataWithPhoto{" +
                "photo='" + photo + '\'' +
                '}';
    }
}
