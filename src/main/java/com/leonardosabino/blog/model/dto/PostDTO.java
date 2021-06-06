package com.leonardosabino.blog.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    @ApiModelProperty(hidden = true)
    private String id;

    @NotNull
    private String title;

    @NotNull
    private String html;

    @ApiModelProperty(hidden = true)
    private LocalDate createdDate;

    @ApiModelProperty(hidden = true)
    private LocalDate lastModifiedDate;
}
