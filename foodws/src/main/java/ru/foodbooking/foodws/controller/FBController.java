package ru.foodbooking.foodws.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.foodbooking.foodws.FBConstant;
import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.support.request.GetRequest;
import ru.foodbooking.foodws.services.FBServices;
import ru.foodbooking.foodws.support.response.FBServicesRes;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class FBController {

    private static Logger LOG = Logger.getLogger(FBController.class);

    @Autowired
    private Map<String, FBServices> fbServices;

    @RequestMapping(method = RequestMethod.GET, value = "/fb")
    @ResponseBody
    public List<FBServicesRes> handleRequest(@RequestParam(value = "method", required = true) String method,
                                             @RequestParam(value = "pointid", required = false) Long pointid,
                                             @RequestParam(value = "address",required = false) String address,
                                             @RequestParam(value = "ctgrid", required = false) Long ctgrid,
                                             @RequestParam(value = "productid", required = false) Long productid,
                                             @RequestParam(value = "phone", required = false) String phone)
            throws FBException {
        FBServices service = fbServices.get(method);
        if (service == null)
            throw new FBException(FBConstant.CODE_TECHNICAL_ERROR, FBConstant.MESSAGE_TECHNICAL_ERROR);
        GetRequest req = new GetRequest.Builder()
                .setPointId(pointid)
                .setAddress(address)
                .setCtgrId(ctgrid)
                .setProductId(productid)
                .setClientPhone(phone)
                .build();
        LOG.debug("Start ["+method+"] in "+new Date());
        List<FBServicesRes> res = service.execute(req);
        LOG.debug("End ["+method+"] in "+new Date());
        return res;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String check(){
        return "Application is running";
    }

}
