package com.dicoding.muadz.footballclub.teamDetail

import com.dicoding.muadz.footballclub.Team

interface TeamDetailView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}