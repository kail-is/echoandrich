package com.test.echoandrich.web.api.list;

import com.test.echoandrich.web.api.out.DjDentistResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(name = "djDentistListUrl", url = "${dj.api.url}")
public interface DjDentistApi {

    @GetMapping
    DjDentistResponse getDentistList(@RequestParam("pageNo") String pageNo,
                                     @RequestParam("numOfRows") String pageNum);

}
