package com.littlefeet.api.models

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotNull

/**
 * 共通エラーオブジェクト
 * @param code エラーコード
 * @param message エラーメッセージ
 */
data class Error (

        @get:NotNull 
        @JsonProperty("code") val code: kotlin.Int,

        @JsonProperty("message") val message: kotlin.String? = null
) {

}

