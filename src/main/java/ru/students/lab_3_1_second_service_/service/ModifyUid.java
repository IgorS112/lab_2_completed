package ru.students.lab_3_1_second_service_.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.students.lab_3_1_second_service_.model.Response;



@Service
@RequiredArgsConstructor
@Qualifier("id1")
public class ModifyUid implements MyModifyService {
    @Override
    public Response modify(Response response) {
        response.setUid("100500");
        return response;
    }
}
