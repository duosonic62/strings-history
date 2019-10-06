package com.littlefeet.api.models

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * メンバー情報変更パラメータ
 * @param name ユーザ名
 */
data class MemberPutParameter (

        @get:NotNull @get:Size(min=1,max=256) 
        @JsonProperty("name") val name: kotlin.String
) {

}

