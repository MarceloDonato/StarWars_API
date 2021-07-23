package com.marcelo.starwars_api.utils

import android.os.Build
import android.text.Html
import android.text.Spanned

object Utils {

    fun getImage(url: String): String {

        return "https://starwars-visualguide.com/assets/img/" + splitString(url) + ".jpg"
    }

    fun getImagePeople(url: String): String {

        return "https://starwars-visualguide.com/assets/img/" + splitPeopleString(url) + ".jpg"
    }

    fun lastString(s: String): String {
        var i = s.length
        while (i > 0 && Character.isDigit(s[i - 1])) {
            i--
        }
        return s.substring(i)
    }

    fun splitString(s: String): String {

        val separated = s.split("/")
        return separated[separated.size - 3] + "/" + separated[separated.size - 2]
    }

    fun splitPeopleString(s: String): String {

        val separated = s.split("/")
        return "characters/" + separated[separated.size - 2]
    }

    @SuppressWarnings("deprecation")
    fun fromHtml(source: String): Spanned {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(source, Html.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(source)
        }
    }
}