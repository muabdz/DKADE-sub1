package com.dicoding.muadz.footballclub.teams

import com.dicoding.muadz.footballclub.TeamResponse
import com.dicoding.muadz.footballclub.apiUtils.ApiRepository
import com.dicoding.muadz.footballclub.apiUtils.TheSportDBApi
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TeamsPresenter(
    private val view: TeamsView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {

    fun getTeamList(league: String?) {
        view.showLoading()
        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getTeams(league)).await(),
                TeamResponse::class.java
            )
            view.hideLoading()
            view.showTeamList(data.teams)
        }
    }
}