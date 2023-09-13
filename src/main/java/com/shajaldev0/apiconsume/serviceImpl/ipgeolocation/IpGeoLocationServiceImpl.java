package com.shajaldev0.apiconsume.serviceImpl.ipgeolocation;

import com.shajaldev0.apiconsume.config.Env;
import com.shajaldev0.apiconsume.mapper.ipgeolocation.GetGeoLocationMapper;
import com.shajaldev0.apiconsume.payload.ipgeolocation.IpGeoLocationResponse;
import com.shajaldev0.apiconsume.service.ipgeolocation.IpGeoLocationService;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.stereotype.Service;

@Service
public class IpGeoLocationServiceImpl implements IpGeoLocationService {
    Env env = new Env();
    private final String BASE_URL = "https://"+env.getEnvIpGeoLocationHost();
    private final String API_KEY = env.getEnvIpGeoLocationApiKey();

    @Override
    public IpGeoLocationResponse getGeoLocation() {

        IpGeoLocationResponse geoLocationResponse = null;
        try{
            HttpResponse<String> response = Unirest.get(BASE_URL+"/ipgeo?apiKey="+API_KEY)
                    .asString();
             geoLocationResponse = GetGeoLocationMapper.mapToIpGeoLocation(response);

             if (response.getStatus() == 200){
                 try{
                     HttpResponse<String> agentResponse = Unirest.get(BASE_URL+"/user-agent?apiKey="+API_KEY)
                             .asString();
                     geoLocationResponse = GetGeoLocationMapper.mapToIpGeoLocationWithAgent(response,agentResponse);
                 }catch (Exception ex){
                     System.out.println(ex);
                 }
             }else {
                 geoLocationResponse = GetGeoLocationMapper.mapToIpGeoLocation(response);
             }
        }catch (Exception ex){
            System.out.println(ex);
        }
        return geoLocationResponse;
    }

}
