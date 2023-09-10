package luat.detest.service;

import luat.detest.entity.Status;
import luat.detest.model.response.StatusResponse;

import java.util.List;

public interface IStatusService {
    List<StatusResponse> getAllStatus();
}
