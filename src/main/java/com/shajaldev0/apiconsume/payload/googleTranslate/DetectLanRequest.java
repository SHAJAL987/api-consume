package com.shajaldev0.apiconsume.payload.googleTranslate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetectLanRequest {
    private String question;
}
