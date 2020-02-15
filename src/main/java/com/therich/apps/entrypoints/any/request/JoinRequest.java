package com.therich.apps.entrypoints.any.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * Created by kh.jin on 2020. 2. 15.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class JoinRequest {

    @JsonProperty("name")
    @NotBlank
    private String name;

    @JsonProperty("post_code")
    private String postCode;

    @JsonProperty("address")
    private String address;

    @JsonProperty("mobile")
    @NotBlank
    private String mobile;

    @JsonProperty("email")
    private String email;

    @JsonProperty("social_id")
    @NotBlank
    private String socialId;

    @JsonProperty("bank_code")
    @NotBlank
    private String bankCode;

    @JsonProperty("bank_account")
    @NotBlank
    private String bankAccount;
}