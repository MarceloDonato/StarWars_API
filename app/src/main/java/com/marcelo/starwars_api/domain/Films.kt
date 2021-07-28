package com.marcelo.starwars_api.domain

import com.google.gson.annotations.SerializedName


data class Films(

	@SerializedName("count") val count: Int,
	@SerializedName("next") val next: String,
	@SerializedName("previous") val previous: String,
	@SerializedName("results") val results: List<FilmsResults>
)