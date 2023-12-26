package com.example.pdfcreator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResidenceCertificateForm {
    private String name;
    private String parent_name;
    private String village;
    private  String taluka;
    private String district;
    private String place_of_register;
    private String date_of_register;
    private String document_for_verify;
}
