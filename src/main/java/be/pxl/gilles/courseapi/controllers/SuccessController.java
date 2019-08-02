package be.pxl.gilles.courseapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/success")
public class SuccessController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String list() {
        return "Your Container is working! :)";
    }

}
