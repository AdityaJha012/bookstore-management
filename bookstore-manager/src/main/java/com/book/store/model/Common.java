package com.book.store.model;

import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.sql.Timestamp;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Common {
    private char validFlag;
    private String createdBy;
    private Timestamp createdAt;
    private String updatedBy;
    private Timestamp updatedAt;
}
