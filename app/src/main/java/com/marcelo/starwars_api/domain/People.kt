package com.marcelo.starwars_api.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class People (

	@SerializedName("count") val count : Int?,
	@SerializedName("next") val next : String?,
	@SerializedName("previous") val previous : String?,
	@SerializedName("results") val results : List<PeopleResults>?

) : Serializable