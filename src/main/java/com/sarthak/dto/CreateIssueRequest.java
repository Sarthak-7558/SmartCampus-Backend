package com.sarthak.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateIssueRequest {

    private String title;
    private String description;
    private String category;
}
