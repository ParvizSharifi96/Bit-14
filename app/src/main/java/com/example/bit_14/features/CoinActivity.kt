package com.example.bit_14.features

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bit_14.apiManager.BASE_URL_TWITTER
import com.example.bit_14.apiManager.model.CoinAboutItem
import com.example.bit_14.apiManager.model.CoinsData
import com.example.bit_14.databinding.ActivityCoinBinding


@Suppress("DEPRECATION")
class CoinActivity : AppCompatActivity() {
    lateinit var binding: ActivityCoinBinding
    lateinit var dataThisCoin: CoinsData.Data
    lateinit var dataThisCoinAbout: CoinAboutItem

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCoinBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val fromIntent = intent.getBundleExtra("bundle")!!
        dataThisCoin = fromIntent.getParcelable<CoinsData.Data>("bundle1")!!
        if (fromIntent.getParcelable<CoinAboutItem>("bundle2") != null) {
            dataThisCoinAbout = fromIntent.getParcelable<CoinAboutItem>("bundle2")!!
        } else {
            dataThisCoinAbout = CoinAboutItem()
        }
        binding.layoutToolbar.toolbar.title = dataThisCoin.coinInfo.fullName
        initUi()

    }


    private fun initUi() {

        initChartUi()
        initStatisticsUi()
        initAboutUi()

    }

    private fun initAboutUi() {
        binding.layoutAbout.txtWebsite.text = dataThisCoinAbout.coinWebsite
        binding.layoutAbout.txtGithub.text = dataThisCoinAbout.coinGithub
        binding.layoutAbout.txtReddit.text = dataThisCoinAbout.coinReddit
        binding.layoutAbout.txtTwitter.text = "@" + dataThisCoinAbout.coinTwitter
        binding.layoutAbout.txtAboutCoin.text = dataThisCoinAbout.coinDesc

        binding.layoutAbout.txtWebsite.setOnClickListener {
            if (dataThisCoinAbout.coinWebsite!!.isNotEmpty()) {
                openWebsiteDataCoin(dataThisCoinAbout.coinWebsite!!)

            } else {

                Toast.makeText(this, "Sorry, no information available", Toast.LENGTH_SHORT).show()
            }


        }

        binding.layoutAbout.txtGithub.setOnClickListener {

            openWebsiteDataCoin(dataThisCoinAbout.coinGithub!!)

        }

        binding.layoutAbout.txtReddit.setOnClickListener {

            openWebsiteDataCoin(dataThisCoinAbout.coinReddit!!)

        }

        binding.layoutAbout.txtTwitter.setOnClickListener {

            openWebsiteDataCoin(BASE_URL_TWITTER + dataThisCoinAbout.coinTwitter!!)

        }


    }


    private fun openWebsiteDataCoin(url: String) {


        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }


    @SuppressLint("SetTextI18n")
    private fun initStatisticsUi() {

        binding.layoutStatistics.tvOpenAmount.text = dataThisCoin.dISPLAY.uSD.oPEN24HOUR
        binding.layoutStatistics.tvTodaysHighAmount.text = dataThisCoin.dISPLAY.uSD.hIGH24HOUR
        binding.layoutStatistics.tvTodayLowAmount.text = dataThisCoin.dISPLAY.uSD.lOW24HOUR
        binding.layoutStatistics.tvChangeTodayAmount.text = dataThisCoin.dISPLAY.uSD.cHANGE24HOUR
        binding.layoutStatistics.tvAlgorithm.text = dataThisCoin.coinInfo.algorithm
        binding.layoutStatistics.tvTotalVolume.text = dataThisCoin.dISPLAY.uSD.tOTALVOLUME24H
        binding.layoutStatistics.tvAvgMarketCapAmount.text = dataThisCoin.dISPLAY.uSD.mKTCAP
        binding.layoutStatistics.tvSupplyNumber.text = dataThisCoin.dISPLAY.uSD.sUPPLY


    }

    private fun initChartUi() {

    }
}