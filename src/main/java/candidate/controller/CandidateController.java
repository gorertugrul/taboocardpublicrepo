package candidate.controller;


import candidate.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import root.controller.AbstractController;
import root.service.AbstractService;

@RestController
@RequestMapping("/candidate")
@CrossOrigin(origins = "*")
public class CandidateController extends AbstractController {

    @Autowired
    CandidateService service;

    @Override
    public AbstractService getService() {
        return this.service;
    }
}
