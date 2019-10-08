package com.littlefeet.api.models

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * メンバー情報
 * @param name ユーザ名
 */
data class MemberInformation (

        @get:NotNull @get:Size(min=1,max=256) 
        @JsonProperty("name") val name: kotlin.String
) {

}

