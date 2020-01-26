package ru.foodbooking.foodws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.foodbooking.foodws.services.FBServices;
import ru.foodbooking.foodws.support.request.FBServicesReq;
import ru.foodbooking.foodws.support.response.FBServicesRes;

import java.util.Map;

@RestController
public class FBController {

    @Autowired
    private Map<String, FBServices> fbServices;

    @RequestMapping(method = RequestMethod.GET, value = "/fb")
    @ResponseBody
    public FBServicesRes handleRequest(@RequestParam("method") String method,
                                       @RequestBody FBServicesReq req) throws Exception {
        FBServices service = fbServices.get(method);
        service.execute(null);
        return null;
    }

}
