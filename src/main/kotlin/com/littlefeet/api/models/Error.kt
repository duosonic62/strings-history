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

