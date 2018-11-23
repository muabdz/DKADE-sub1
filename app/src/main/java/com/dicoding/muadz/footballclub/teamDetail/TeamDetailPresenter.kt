package com.dicoding.muadz.footballclub.teamDetail

import com.dicoding.muadz.footballclub.TeamResponse
import com.dicoding.muadz.footballclub.apiUtils.ApiRepository
import com.dicoding.muadz.footballclub.apiUtils.TheSportDBApi
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamDetailPresenter(private val view: TeamDetailView,
                          private val apiRepository: ApiRepository,
                          private val gson: Gson) {
    fun getTeamDetail(teamId: String){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeamDetail(teamId)),
                TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamDetail(data.teams)
            }
        }
    }
}