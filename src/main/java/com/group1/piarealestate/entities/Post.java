package com.group1.piarealestate.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class Post {

    private String id;

    private String title;

    private String description;

    private String price;


}
