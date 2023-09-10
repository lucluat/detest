package luat.detest.model.mapper;

import luat.detest.entity.Status;
import luat.detest.model.response.StatusResponse;
import org.springframework.stereotype.Component;

@Component
public class StatusMapper {
    public StatusResponse toResponse(Status status){
        StatusResponse response = new StatusResponse();
        response.setId(status.getId());
        response.setStatusName(status.getStatusName());
        return response;
    }
}
