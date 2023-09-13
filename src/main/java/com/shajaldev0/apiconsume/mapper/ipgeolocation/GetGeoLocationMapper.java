package com.shajaldev0.apiconsume.mapper.ipgeolocation;

import com.shajaldev0.apiconsume.payload.ipgeolocation.*;
import kong.unirest.HttpResponse;
import kong.unirest.json.JSONObject;

public class GetGeoLocationMapper {
    public static IpGeoLocationResponse mapToIpGeoLocation(HttpResponse<String> res){
        CurrencyObj currency = new CurrencyObj();
        TimeZoneObj timeZone = new TimeZoneObj();
        IpGeoLocationResponse response = new IpGeoLocationResponse();
        JSONObject resJson = new JSONObject(res.getBody());
        currency.setCode(resJson.getJSONObject("currency").getString("code"));
        currency.setName(resJson.getJSONObject("currency").getString("name"));
        currency.setSymbol(resJson.getJSONObject("currency").getString("symbol"));
        timeZone.setName(resJson.getJSONObject("time_zone").getString("name"));
        timeZone.setOffset(resJson.getJSONObject("time_zone").getInt("offset"));
        timeZone.setOffsetWithDst(resJson.getJSONObject("time_zone").getInt("offset_with_dst"));
        timeZone.setCurrentTime(resJson.getJSONObject("time_zone").getString("current_time"));
        timeZone.setCurrentTimeUnix(resJson.getJSONObject("time_zone").getDouble("current_time_unix"));
        timeZone.setIsDst(resJson.getJSONObject("time_zone").getBoolean("is_dst"));
        timeZone.setDst_savings(resJson.getJSONObject("time_zone").getInt("dst_savings"));
        response.setIp(resJson.getString("ip"));
        response.setContinentCode(resJson.getString("continent_code"));
        response.setContinentName(resJson.getString("continent_name"));
        response.setCountryCode2(resJson.getString("country_code2"));
        response.setCountryCode3(resJson.getString("country_code3"));
        response.setCountryName(resJson.getString("country_name"));
        response.setCountryCapital(resJson.getString("country_capital"));
        response.setStateProv(resJson.getString("state_prov"));
        response.setStateCode(resJson.getString("state_code"));
        response.setDistrict(resJson.getString("district"));
        response.setCity(resJson.getString("city"));
        response.setZipcode(resJson.getString("zipcode"));
        response.setLatitude(resJson.getString("latitude"));
        response.setLongitude(resJson.getString("longitude"));
        response.setIsEu(resJson.getBoolean("is_eu"));
        response.setCallingCode(resJson.getString("calling_code"));
        response.setCountryTld(resJson.getString("country_tld"));
        response.setLanguages(resJson.getString("languages"));
        response.setCountryFlag(resJson.getString("country_flag"));
        response.setGeonameId(resJson.getString("geoname_id"));
        response.setIsp(resJson.getString("isp"));
        response.setConnectionType(resJson.getString("connection_type"));
        response.setOrganization(resJson.getString("organization"));
        response.setCurrency(currency);
        response.setTimeZone(timeZone);
        return response;
    }
    public static IpGeoLocationResponse mapToIpGeoLocationWithAgent(HttpResponse<String> geoRes, HttpResponse<String> agentRes){
        CurrencyObj currency = new CurrencyObj();
        TimeZoneObj timeZone = new TimeZoneObj();
        DeviceObj device = new DeviceObj();
        EngineObj engine = new EngineObj();
        OperatingSystemObj operatingSystem = new OperatingSystemObj();
        UserAgentResponse userAgent = new UserAgentResponse();
        IpGeoLocationResponse response = new IpGeoLocationResponse();
        JSONObject resJson = new JSONObject(geoRes.getBody());
        JSONObject resJsonAgn = new JSONObject(agentRes.getBody());
        currency.setCode(resJson.getJSONObject("currency").getString("code"));
        currency.setName(resJson.getJSONObject("currency").getString("name"));
        currency.setSymbol(resJson.getJSONObject("currency").getString("symbol"));
        timeZone.setName(resJson.getJSONObject("time_zone").getString("name"));
        timeZone.setOffset(resJson.getJSONObject("time_zone").getInt("offset"));
        timeZone.setOffsetWithDst(resJson.getJSONObject("time_zone").getInt("offset_with_dst"));
        timeZone.setCurrentTime(resJson.getJSONObject("time_zone").getString("current_time"));
        timeZone.setCurrentTimeUnix(resJson.getJSONObject("time_zone").getDouble("current_time_unix"));
        timeZone.setIsDst(resJson.getJSONObject("time_zone").getBoolean("is_dst"));
        timeZone.setDst_savings(resJson.getJSONObject("time_zone").getInt("dst_savings"));
        device.setName(resJsonAgn.getJSONObject("device").getString("name"));
        device.setType(resJsonAgn.getJSONObject("device").getString("type"));
        device.setBrand(resJsonAgn.getJSONObject("device").getString("brand"));
        device.setCpu(resJsonAgn.getJSONObject("device").getString("cpu"));
        engine.setName(resJsonAgn.getJSONObject("engine").getString("name"));
        engine.setType(resJsonAgn.getJSONObject("engine").getString("type"));
        engine.setVersion(resJsonAgn.getJSONObject("engine").getString("version"));
        engine.setVersionMajor(resJsonAgn.getJSONObject("engine").getString("versionMajor"));
        operatingSystem.setName(resJsonAgn.getJSONObject("operatingSystem").getString("name"));
        operatingSystem.setType(resJsonAgn.getJSONObject("operatingSystem").getString("type"));
        operatingSystem.setVersion(resJsonAgn.getJSONObject("operatingSystem").getString("version"));
        operatingSystem.setVersionMajor(resJsonAgn.getJSONObject("operatingSystem").getString("versionMajor"));
        userAgent.setUserAgentString(resJsonAgn.getString("userAgentString"));
        userAgent.setName(resJsonAgn.getString("name"));
        userAgent.setType(resJsonAgn.getString("type"));
        userAgent.setVersion(resJsonAgn.getString("version"));
        userAgent.setVersionMajor(resJsonAgn.getString("versionMajor"));
        userAgent.setDevice(device);
        userAgent.setEngine(engine);
        userAgent.setOperatingSystem(operatingSystem);
        response.setIp(resJson.getString("ip"));
        response.setContinentCode(resJson.getString("continent_code"));
        response.setContinentName(resJson.getString("continent_name"));
        response.setCountryCode2(resJson.getString("country_code2"));
        response.setCountryCode3(resJson.getString("country_code3"));
        response.setCountryName(resJson.getString("country_name"));
        response.setCountryCapital(resJson.getString("country_capital"));
        response.setStateProv(resJson.getString("state_prov"));
        response.setStateCode(resJson.getString("state_code"));
        response.setDistrict(resJson.getString("district"));
        response.setCity(resJson.getString("city"));
        response.setZipcode(resJson.getString("zipcode"));
        response.setLatitude(resJson.getString("latitude"));
        response.setLongitude(resJson.getString("longitude"));
        response.setIsEu(resJson.getBoolean("is_eu"));
        response.setCallingCode(resJson.getString("calling_code"));
        response.setCountryTld(resJson.getString("country_tld"));
        response.setLanguages(resJson.getString("languages"));
        response.setCountryFlag(resJson.getString("country_flag"));
        response.setGeonameId(resJson.getString("geoname_id"));
        response.setIsp(resJson.getString("isp"));
        response.setConnectionType(resJson.getString("connection_type"));
        response.setOrganization(resJson.getString("organization"));
        response.setCurrency(currency);
        response.setTimeZone(timeZone);
        response.setUserAgent(userAgent);
        return response;
    }
}