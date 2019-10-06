package com.littlefeet.api.models

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * メンバー登録情報
 * @param token アクセストークン
 * @param name ユーザ名
 */
data class MemberRegisterInformation (

        @get:NotNull 
        @JsonProperty("token") val token: kotlin.String,

        @get:NotNull @get:Size(min=1,max=256) 
        @JsonProperty("name") val name: kotlin.String
) {

}

