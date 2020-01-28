package ru.foodbooking.foodws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.foodbooking.foodws.FBConstant;
import ru.foodbooking.foodws.FBException;
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
                                       @RequestBody FBServicesReq req)
            throws FBException {
        FBServices service = fbServices.get(method);
        if (service == null)
            throw new FBException(FBConstant.CODE_TECHNICAL_ERROR, FBConstant.MESSAGE_TECHNICAL_ERROR);
        service.execute(null);
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String check(){
        return "Application is running";
    }

}
