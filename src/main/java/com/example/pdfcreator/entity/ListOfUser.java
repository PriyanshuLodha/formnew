package com.example.pdfcreator.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class   ListOfUser {
    private String username;
    private String filename;
    private ArrayList<String> listUser;
}
