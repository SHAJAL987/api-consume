package com.shajaldev0.apiconsume.service.googleTranslate;

import com.shajaldev0.apiconsume.payload.googleTranslate.DetectLanRequest;
import com.shajaldev0.apiconsume.payload.googleTranslate.DetectionLanResponse;
import kong.unirest.UnirestException;

public interface TranslateService {
    public DetectionLanResponse detectLanguage(DetectLanRequest request) throws UnirestException;
}
