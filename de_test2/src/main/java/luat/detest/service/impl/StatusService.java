package luat.detest.service.impl;

import luat.detest.entity.Status;
import luat.detest.model.mapper.StatusMapper;
import luat.detest.model.response.StatusResponse;
import luat.detest.repository.IStatusRepository;
import luat.detest.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusService implements IStatusService {
    @Autowired
    private IStatusRepository iStatusRepository;
    @Autowired
    private StatusMapper statusMapper;
    @Override
    public List<StatusResponse> getAllStatus(){
        List<Status>statuses=iStatusRepository.findAll();
        List<StatusResponse> responses= new ArrayList<>();
        for (Status status :
                statuses) {
            responses.add(statusMapper.toResponse(status));
        }
        return responses;
    }
}
