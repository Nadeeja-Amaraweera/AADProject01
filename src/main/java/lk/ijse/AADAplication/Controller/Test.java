package lk.ijse.AADAplication.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("v1/api")
public class Test {
    @GetMapping("/ping")
    public String ping(){
        log.info("-------------------Rest Api-----------------");
        return "Application is running...";
    }
}
