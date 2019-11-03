package com.littlefeet.api.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

/**
 * メンバー登録パラメータ
 * @param uid firebaseで払い出されたuid
 * @param name ユーザ名
 */
data class MemberPostParameter (

        @get:NotNull 
        @JsonProperty("uid") val uid: kotlin.String,

        @get:NotNull @get:Size(min=1,max=256) 
        @JsonProperty("name") val name: kotlin.String
) {

}

