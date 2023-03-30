package com.example.bit_14.apiManager.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoinAboutItem(

    val coinWebsite : String? = "No - Data",
    val coinGithub: String?= "No - Data",
    val coinTwitter:String?= "No - Data",
    val coinDesc:String?= "No - Data",
    val coinReddit : String?= "No - Data"
):Parcelable