package com.therich.apps.entrypoints.controllers.owner;

import com.therich.apps.entrypoints.controllers.BaseRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kh.jin on 2020. 3. 2.
 */
@RestController
public class ProfileRestController extends BaseRestController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/owner/{memberNo}/profile")
    public void profile(@PathVariable("memberNo") Long memberNo) {
        log.info("/Owner.");
    }
}
