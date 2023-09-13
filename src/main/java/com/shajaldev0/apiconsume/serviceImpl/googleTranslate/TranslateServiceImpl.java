package com.shajaldev0.apiconsume.serviceImpl.googleTranslate;
import com.shajaldev0.apiconsume.config.Env;
import com.shajaldev0.apiconsume.payload.googleTranslate.DetectLanRequest;
import com.shajaldev0.apiconsume.payload.googleTranslate.DetectionLanResponse;
import com.shajaldev0.apiconsume.service.googleTranslate.TranslateService;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class TranslateServiceImpl implements TranslateService {

    Env env = new Env();
    private final String BASE_URL = "https://"+env.getEnvRapidHost();
    private final String RAPID_API_HOST = env.getEnvRapidHost();
    private final String RAPID_API_KEY = env.getEnvRapidApiKey();

    @Override
    public DetectionLanResponse detectLanguage(DetectLanRequest request){
        DetectionLanResponse detectionObj = new DetectionLanResponse();
        try {
            HttpResponse<String> response = Unirest.post(BASE_URL+"/language/translate/v2/detect")
                    .header("content-type", "application/x-www-form-urlencoded")
                    .header("Accept-Encoding", "application/gzip")
                    .header("X-RapidAPI-Key", RAPID_API_KEY)
                    .header("X-RapidAPI-Host", RAPID_API_HOST)
                    .field("q", request.getQuestion())
                    .asString();

            JSONObject resJsonObj = new JSONObject(response.getBody());
            JSONArray detections = resJsonObj.getJSONObject("data")
                    .getJSONArray("detections").getJSONArray(0);

            double confidence = detections.getJSONObject(0).getDouble("confidence");
            String language = detections.getJSONObject(0).getString("language");
            boolean isReliable = detections.getJSONObject(0).getBoolean("isReliable");

            detectionObj.setLanguage(language);
            detectionObj.setConfidence(confidence);
            detectionObj.setReliable(isReliable);

            return detectionObj;

        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
