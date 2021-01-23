package com.androidcodes.zomatoapp.model

data class SearchModel(
    val restaurants: List<Restaurant>,
    val results_found: Int,
    val results_shown: Int,
    val results_start: Int
)