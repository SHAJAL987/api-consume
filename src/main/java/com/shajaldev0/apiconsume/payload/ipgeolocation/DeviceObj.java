package com.shajaldev0.apiconsume.payload.ipgeolocation;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeviceObj {
    private String name;
    private String type;
    private String brand;
    private String cpu;
}
