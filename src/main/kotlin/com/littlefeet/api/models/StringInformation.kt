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
 * メンバー登録情報
 * @param id 弦ID
 * @param name 弦名
 * @param description 弦説明
 * @param maker 弦メーカー
 * @param thinGauge 細い弦のゲージ
 * @param thickGauge 太い弦のゲージ
 * @param url 弦メーカー
 */
data class StringInformation (

        @get:NotNull 
        @JsonProperty("id") val id: kotlin.String,

        @get:NotNull @get:Size(min=1,max=64) 
        @JsonProperty("name") val name: kotlin.String,

        @get:NotNull @get:Size(min=1,max=1024) 
        @JsonProperty("description") val description: kotlin.String,

        @get:NotNull @get:Size(min=1,max=64) 
        @JsonProperty("maker") val maker: kotlin.String,

        @get:NotNull @get:Min(1) @get:Max(100) 
        @JsonProperty("thinGauge") val thinGauge: kotlin.Int,

        @get:NotNull @get:Min(1) @get:Max(100) 
        @JsonProperty("thickGauge") val thickGauge: kotlin.Int,
@get:Size(min=1,max=256) 
        @JsonProperty("url") val url: kotlin.String? = null
) {

}

