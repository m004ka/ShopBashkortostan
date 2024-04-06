package org.urr.shopbashkortostan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.urr.shopbashkortostan.enums.Rating;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FeedbackDTO {
    String text;
    Rating rating;
}
