package com.littlefeet.api.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import com.littlefeet.api.models.GuitarBodyType
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

/**
 * ギター登録パラメータ
 * @param name ギター名
 * @param description ギター説明
 * @param maker ギターメーカー
 * @param bodyType 
 */
data class GuitarRegisterParameter (

        @get:NotNull @get:Size(min=1,max=64) 
        @JsonProperty("name") val name: kotlin.String,

        @get:NotNull @get:Size(min=1,max=1024) 
        @JsonProperty("description") val description: kotlin.String,

        @get:NotNull @get:Size(min=1,max=64) 
        @JsonProperty("maker") val maker: kotlin.String,

        @get:NotNull 
        @JsonProperty("bodyType") val bodyType: GuitarBodyType
) {

}

