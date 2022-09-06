package com.example.assignment_5.models

import com.google.gson.annotations.SerializedName


data class EverythingModel (

  @SerializedName("status"       ) var status       : String?             = null,
  @SerializedName("totalResults" ) var totalResults : Int?                = null,
  @SerializedName("articles"     ) var articles     : ArrayList<Articles> = arrayListOf()

)