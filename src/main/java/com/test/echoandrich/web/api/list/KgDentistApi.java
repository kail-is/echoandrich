package com.test.echoandrich.web.api.list;

import com.test.echoandrich.config.FeignConfig;
import com.test.echoandrich.web.api.out.KgDentistResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Component
@FeignClient(name = "kgDentistListUrl", url = "${kg.api.url}", configuration = FeignConfig.class)
public interface KgDentistApi {

    @GetMapping
    KgDentistResponse getDentistList(@RequestParam("pIndex") String pageNo,
                                     @RequestParam("pSize") String numOfRows,
                                     @RequestParam("key") String key,
                                     @RequestParam("Type") String type);

}
