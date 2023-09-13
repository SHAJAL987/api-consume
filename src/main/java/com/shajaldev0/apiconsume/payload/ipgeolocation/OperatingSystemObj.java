package com.shajaldev0.apiconsume.payload.ipgeolocation;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OperatingSystemObj {
    private String name;
    private String type;
    private String version;
    private String versionMajor;
}
