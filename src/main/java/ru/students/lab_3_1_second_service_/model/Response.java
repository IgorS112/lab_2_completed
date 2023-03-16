package ru.students.lab_3_1_second_service_.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {


        private String uid;
        private String operationUid;
        private String systemTime;
        private String code;
        private String errorCode;
        private String errorMessage;

}
