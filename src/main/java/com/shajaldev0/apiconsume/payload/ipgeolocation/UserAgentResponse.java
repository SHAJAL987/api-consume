package com.shajaldev0.apiconsume.payload.ipgeolocation;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserAgentResponse {
    private String userAgentString;
    private String name;
    private String type;
    private String version;
    private String versionMajor;
    private DeviceObj device;
    private EngineObj engine;
    private OperatingSystemObj operatingSystem;
}
