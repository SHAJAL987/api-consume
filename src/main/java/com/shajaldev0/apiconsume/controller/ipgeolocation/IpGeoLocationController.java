package com.shajaldev0.apiconsume.controller.ipgeolocation;

import com.shajaldev0.apiconsume.common.ResponseHandler;
import com.shajaldev0.apiconsume.payload.ipgeolocation.IpGeoLocationResponse;
import com.shajaldev0.apiconsume.service.ipgeolocation.IpGeoLocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dev0/geo/v1")
public class IpGeoLocationController {
    IpGeoLocationService ipGeoLocationService;

    public IpGeoLocationController(IpGeoLocationService ipGeoLocationService) {
        this.ipGeoLocationService = ipGeoLocationService;
    }

    @GetMapping("/location")
    public ResponseEntity<Object> getGeoLocation(){
        Map<String, Object> resData = new HashMap<>();
        IpGeoLocationResponse response = ipGeoLocationService.getGeoLocation();
        resData.put("data",resData);
        return ResponseHandler.responseBuilder("Operation Successful", "ERR-100", response);
    }
}
