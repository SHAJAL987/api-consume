package com.shajaldev0.apiconsume.controller.googleTranslate;

import com.shajaldev0.apiconsume.common.ResponseHandler;
import com.shajaldev0.apiconsume.payload.googleTranslate.DetectLanRequest;
import com.shajaldev0.apiconsume.payload.googleTranslate.DetectionLanResponse;
import com.shajaldev0.apiconsume.service.googleTranslate.TranslateService;
import kong.unirest.UnirestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dev0/translate/v1")
public class TranslateController {

    TranslateService translateService;

    public TranslateController(TranslateService translateService) {
        this.translateService = translateService;
    }

    /************ API Health Check *****************/
    @GetMapping("/healthCheck")
    public String tst(){
        return "API Health is OK !!";
    }

    /************** Detect Language ****************/
    @PostMapping("/detectlanguage")
    public ResponseEntity<Object> detectLanguage(@RequestBody DetectLanRequest detectLanRequest) {
        DetectionLanResponse res = null;
        Map<String, Object> resData;
        try {
            res = translateService.detectLanguage(detectLanRequest);
            resData = new HashMap<>();
            resData.put("detections", res);
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
        return ResponseHandler.responseBuilder("Operation Successful", "ERR-100", resData);
    }


}
