package com.dicoding.muadz.footballclub.teamDetail

import com.dicoding.muadz.footballclub.TeamResponse
import com.dicoding.muadz.footballclub.apiUtils.ApiRepository
import com.dicoding.muadz.footballclub.apiUtils.TheSportDBApi
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TeamDetailPresenter(
    private val view: TeamDetailView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {

    fun getTeamDetail(teamId: String) {
        view.showLoading()
        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getTeamDetail(teamId)).await(),
                TeamResponse::class.java
            )
            view.hideLoading()
            view.showTeamDetail(data.teams)

        }
    }
}