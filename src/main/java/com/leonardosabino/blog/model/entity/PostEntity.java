package com.leonardosabino.blog.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Document(value = "post")
@TypeAlias(value = "post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity implements Serializable {

    private static final long serialVersionUID = 2575889974792916193L;

    @Id
    private String id;

    private String title;

    private String html;

    @CreatedDate
    private LocalDate createdDate;

    @LastModifiedDate
    private LocalDate lastModifiedDate;
}
