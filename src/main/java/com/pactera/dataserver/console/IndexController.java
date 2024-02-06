package com.pactera.dataserver.console;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cht
 */
@RestController
public class IndexController {
    @GetMapping(value = {"/"})
    public ResponseEntity<String> index() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

