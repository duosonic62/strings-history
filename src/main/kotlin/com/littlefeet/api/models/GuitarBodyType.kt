package com.littlefeet.api.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonValue
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

/**
* ギターボディータイプ
* Values: sTRATOCASTER,tELECASTER,jAZZMASTER,jAGUAR,mUSTANG,lESPAUL,sEMIACOUSTIC,fULLACOUSTIC,sG,fLYINGV,eXPLORER,fIREBIRD,aCOUSTIC,pRECISIONBASS,jAZZBASE,oTHERGUITAR,oTHERBASE
*/
enum class GuitarBodyType(val value: kotlin.String) {

    sTRATOCASTER("STRATOCASTER"),

    tELECASTER("TELECASTER"),

    jAZZMASTER("JAZZ_MASTER"),

    jAGUAR("JAGUAR"),

    mUSTANG("MUSTANG"),

    lESPAUL("LES_PAUL"),

    sEMIACOUSTIC("SEMI_ACOUSTIC"),

    fULLACOUSTIC("FULL_ACOUSTIC"),

    sG("SG"),

    fLYINGV("FLYING_V"),

    eXPLORER("EXPLORER"),

    fIREBIRD("FIRE_BIRD"),

    aCOUSTIC("ACOUSTIC"),

    pRECISIONBASS("PRECISION_BASS"),

    jAZZBASE("JAZZ_BASE"),

    oTHERGUITAR("OTHER_GUITAR"),

    oTHERBASE("OTHER_BASE");

}

