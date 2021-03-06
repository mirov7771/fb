package ru.foodbooking.foodws.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.foodbooking.foodws.FBConstant;
import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.config.FBConfig;
import ru.foodbooking.foodws.health.HealthCheck;
import ru.foodbooking.foodws.services.post.PostServices;
import ru.foodbooking.foodws.support.request.GetRequest;
import ru.foodbooking.foodws.services.get.GetServices;
import ru.foodbooking.foodws.support.request.PostRequest;
import ru.foodbooking.foodws.support.response.GetResponse;
import ru.foodbooking.foodws.support.response.PostResponse;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("foodws")
@Slf4j
public class FBController {

    @Autowired
    private FBConfig fbConfig;

    @Autowired
    private Map<String, GetServices> getServices;

    @Autowired
    private Map<String, PostServices> postServices;

    @Autowired
    private HealthCheck healthCheck;

    @RequestMapping(method = RequestMethod.GET, value = "/v1/fb")
    @ResponseBody
    public List<GetResponse> handleRequest(@RequestParam(value = "method", required = true) String method,
                                           @RequestParam(value = "pointid", required = false) Long pointid,
                                           @RequestParam(value = "address",required = false) String address,
                                           @RequestParam(value = "ctgrid", required = false) Long ctgrid,
                                           @RequestParam(value = "productid", required = false) Long productid,
                                           @RequestParam(value = "phone", required = false) String phone,
                                           @RequestHeader("X-AUTH-TOKEN") String token)
            throws FBException
    {
        checkToken(token);
        GetServices service = getServices.get(method);
        if (service == null)
            throw new FBException(FBConstant.CODE_TECHNICAL_ERROR, FBConstant.MESSAGE_TECHNICAL_ERROR);
        GetRequest req = new GetRequest.Builder()
                .setPointId(pointid)
                .setAddress(address)
                .setCtgrId(ctgrid)
                .setProductId(productid)
                .setClientPhone(phone)
                .build();
        log.debug("Start ["+method+"] in "+new Date());
        List<GetResponse> res = service.execute(req);
        log.debug("End ["+method+"] in "+new Date());
        return res;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/v1/fb")
    @ResponseBody
    @Transactional
    public PostResponse execute(@RequestParam("method") String method,
                                @RequestBody PostRequest request,
                                @RequestHeader("X-AUTH-TOKEN") String token)
            throws FBException
    {
        checkToken(token);
        PostServices service = postServices.get(method);
        if (service == null)
            throw new FBException(FBConstant.CODE_TECHNICAL_ERROR, FBConstant.MESSAGE_TECHNICAL_ERROR);
        return service.execute(request);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String check(){
        return "Application is running";
    }

    private void checkToken(String token) throws FBException
    {
        if (token == null || !token.equals(fbConfig.getAccessToken()))
            throw new FBException(FBConstant.CODE_TECHNICAL_ERROR, FBConstant.MESSAGE_TECHNICAL_ERROR);
    }

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public Health healthCheak(){
        return healthCheck.health();
    }
}
