package ru.students.lab_3_1_second_service_.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.students.lab_3_1_second_service_.model.Request;
import ru.students.lab_3_1_second_service_.model.Response;
import ru.students.lab_3_1_second_service_.service.MyModifyService;


@Slf4j
@RestController
public class MyController {

    private final MyModifyService myModifyService;

    @Autowired
    public MyController(@Qualifier("ModifySystemTime") MyModifyService myModifyService) {
        this.myModifyService = myModifyService;
    }



    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@RequestBody Request request){

        System.out.println("hello");

        log.info("Входящий request : " + request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("just success")
                .errorCode("")
                .errorMessage("")
                .build();

        Response responseAfterModify = myModifyService.modify(response);
        log.info("Исходящий response : " + response);



        log.warn("Опасно");
        log.warn("Очень опасно");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
