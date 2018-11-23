package com.dicoding.muadz.footballclub.apiUtils

import java.net.URL


class ApiRepository {

    fun doRequest(url: String): String {
        return URL(url).readText()
    }
}