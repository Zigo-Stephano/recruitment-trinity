package com.example.recruitmenttrinity.data.model

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class ResponseUser(

    @SerializedName("id")
    var id: String? = null,

    @SerializedName("firstname")
    var firstname: String? = null,

    @SerializedName("lastname")
    var lastname: String? = null,

    @SerializedName("email")
    var email: String? = null,

    @SerializedName("phone")
    var phone: String? = null,

)
