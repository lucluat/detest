package luat.detest.restcontroller;

import luat.detest.model.response.StatusResponse;
import luat.detest.service.impl.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/statuses")
public class StatusController {

    @Autowired
    private StatusService statusService;
    @GetMapping("")
    public List<StatusResponse> statuses() {
        return statusService.getAllStatus();
    }

}
