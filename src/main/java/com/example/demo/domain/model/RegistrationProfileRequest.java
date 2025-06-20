package com.example.demo.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationProfileRequest {
    @JsonProperty("ref_id")
    private String refId;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("hkid")
    private String hkid;
    @JsonProperty("passport_no")
    private String passportNo;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("contact_no")
    private String contactNo;
    @JsonProperty("DOB")
    private String dob;
    @JsonProperty("email")
    private String email;
    @JsonProperty("opt_in")
    private String optIn;
} 