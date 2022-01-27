package com.github.rod1andrade.studyspringboot.resources.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StandardError implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    @Getter
    @Setter
    private Instant timestamp;

    @Getter
    @Setter
    private Integer status;

    @Getter
    @Setter
    private String error;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private String path;
}
