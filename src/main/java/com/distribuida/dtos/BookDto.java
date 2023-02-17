package com.distribuida.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    private Integer id;
    private String isbn;
    private String title;
    private Integer author;
    private Double price;

    private String authorName;
}
