package com.test.echoandrich.web.api.list;

import com.test.echoandrich.web.api.out.DgDentistResponse;
import com.test.echoandrich.web.api.out.DgDentistResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(name = "dgDentistListUrl", url = "${dg.api.url}")
public interface DgDentistApi {

    @GetMapping
    DgDentistResponse getDentistList(@RequestParam("page") String pageNo,
                                     @RequestParam("perPage") String pageNum,
                                     @RequestParam("serviceKey") String serviceKey);

}
