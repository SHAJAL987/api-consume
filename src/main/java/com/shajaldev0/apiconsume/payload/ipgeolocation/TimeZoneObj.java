package com.shajaldev0.apiconsume.payload.ipgeolocation;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TimeZoneObj {
    private String name;
    private int offset;
    private int offsetWithDst;
    private String currentTime;
    private Double currentTimeUnix;
    private Boolean isDst;
    private int dst_savings;
}
