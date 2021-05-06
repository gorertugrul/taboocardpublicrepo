package live.controller;

import live.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import root.controller.AbstractController;
import root.service.AbstractService;

@RestController
@RequestMapping("/live")
@CrossOrigin(origins = "*")
public class LiveController extends AbstractController {

    @Autowired
    LiveService service;

    @Override
    public AbstractService getService() {
        return this.service;
    }
}
