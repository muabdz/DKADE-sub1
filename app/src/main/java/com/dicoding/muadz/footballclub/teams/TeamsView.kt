package com.dicoding.muadz.footballclub.teams

import com.dicoding.muadz.footballclub.Team

interface TeamsView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}