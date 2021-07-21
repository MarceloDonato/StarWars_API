import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2021 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class Results (

	@SerializedName("name") val name : String,
	@SerializedName("height") val height : Int,
	@SerializedName("mass") val mass : Int,
	@SerializedName("hair_color") val hair_color : String,
	@SerializedName("skin_color") val skin_color : String,
	@SerializedName("eye_color") val eye_color : String,
	@SerializedName("birth_year") val birth_year : String,
	@SerializedName("gender") val gender : String,
	@SerializedName("homeworld") val homeworld : String,
	@SerializedName("films") val films : List<String>,
	@SerializedName("species") val species : List<String>,
	@SerializedName("vehicles") val vehicles : List<String>,
	@SerializedName("starships") val starships : List<String>,
	@SerializedName("created") val created : String,
	@SerializedName("edited") val edited : String,
	@SerializedName("url") val url : String
)

