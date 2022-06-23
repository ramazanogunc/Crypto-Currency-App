package com.ramo.cryptocurrency.data.remote.model.response

import com.google.gson.annotations.SerializedName
import com.ramo.cryptocurrency.domain.model.CoinDetail
import com.ramo.cryptocurrency.domain.model.Prices

data class CoinDetailResponse(

    @field:SerializedName("localization")
    val localization: Localization? = null,

    @field:SerializedName("symbol")
    val symbol: String? = null,

    @field:SerializedName("sentiment_votes_up_percentage")
    val sentimentVotesUpPercentage: Double? = null,

    @field:SerializedName("asset_platform_id")
    val assetPlatformId: String? = null,

    @field:SerializedName("public_notice")
    val publicNotice: String? = null,

    @field:SerializedName("description")
    val description: Description? = null,

    @field:SerializedName("market_cap_rank")
    val marketCapRank: Long? = null,

    @field:SerializedName("contract_address")
    val contractAddress: String? = null,

    @field:SerializedName("sentiment_votes_down_percentage")
    val sentimentVotesDownPercentage: Double? = null,

    @field:SerializedName("liquidity_score")
    val liquidityScore: Double? = null,

    @field:SerializedName("additional_notices")
    val additionalNotices: List<Any?>? = null,

    @field:SerializedName("coingecko_score")
    val coingeckoScore: Double? = null,


    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("categories")
    val categories: List<Any?>? = null,

    @field:SerializedName("genesis_date")
    val genesisDate: Any? = null,

    @field:SerializedName("image")
    val image: Image? = null,

    @field:SerializedName("last_updated")
    val lastUpdated: String? = null,

    @field:SerializedName("country_origin")
    val countryOrigin: String? = null,

    @field:SerializedName("public_interest_score")
    val publicInterestScore: Double? = null,

    @field:SerializedName("status_updates")
    val statusUpdates: List<Any?>? = null,

    @field:SerializedName("community_score")
    val communityScore: Double? = null,

    @field:SerializedName("developer_score")
    val developerScore: Double? = null,

    @field:SerializedName("market_data")
    val marketData: MarketData? = null,

    @field:SerializedName("block_time_in_minutes")
    val blockTimeInMinutes: Long? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("coingecko_rank")
    val coingeckoRank: Long? = null,

    @field:SerializedName("hashing_algorithm")
    val hashingAlgorithm: Any? = null
) {
    fun toCoinDetail() = CoinDetail(
        id = id ?: "",
        name = name ?: "",
        symbol = symbol ?: "",
        price = marketData?.currentPrice?.toPrices() ?: Prices(),
        description = description?.tr,
        imageUrl = image?.small ?: ""
    )
}

data class MarketData(

    @field:SerializedName("price_change_percentage_24h")
    val priceChangePercentage24h: Double? = null,

    @field:SerializedName("price_change_24h")
    val priceChange24h: Double? = null,

    @field:SerializedName("mcap_to_tvl_ratio")
    val mcapToTvlRatio: Any? = null,

    @field:SerializedName("market_cap_rank")
    val marketCapRank: Long? = null,

    @field:SerializedName("roi")
    val roi: Any? = null,

    @field:SerializedName("atl_date")
    val atlDate: AtlDate? = null,

    @field:SerializedName("market_cap")
    val marketCap: MarketCap? = null,

    @field:SerializedName("circulating_supply")
    val circulatingSupply: Double? = null,

    @field:SerializedName("last_updated")
    val lastUpdated: String? = null,

    @field:SerializedName("total_value_locked")
    val totalValueLocked: Any? = null,

    @field:SerializedName("total_supply")
    val totalSupply: Double? = null,

    @field:SerializedName("max_supply")
    val maxSupply: Double? = null,

    @field:SerializedName("current_price")
    val currentPrice: CurrentPrice? = null,

    @field:SerializedName("price_change_percentage_1y")
    val priceChangePercentage1y: Double? = null
)

data class CurrentPrice(

    @field:SerializedName("usd")
    val usd: Double? = null,

    @field:SerializedName("xdr")
    val xdr: Double? = null,

    @field:SerializedName("eos")
    val eos: Double? = null,

    @field:SerializedName("sgd")
    val sgd: Double? = null,

    @field:SerializedName("vef")
    val vef: Double? = null,

    @field:SerializedName("bnb")
    val bnb: Double? = null,

    @field:SerializedName("eth")
    val eth: Double? = null,

    @field:SerializedName("nzd")
    val nzd: Double? = null,

    @field:SerializedName("brl")
    val brl: Double? = null,

    @field:SerializedName("xag")
    val xag: Double? = null,

    @field:SerializedName("chf")
    val chf: Double? = null,

    @field:SerializedName("mxn")
    val mxn: Double? = null,

    @field:SerializedName("clp")
    val clp: Double? = null,

    @field:SerializedName("bits")
    val bits: Double? = null,

    @field:SerializedName("zar")
    val zar: Double? = null,

    @field:SerializedName("vnd")
    val vnd: Double? = null,

    @field:SerializedName("xau")
    val xau: Double? = null,

    @field:SerializedName("aud")
    val aud: Double? = null,

    @field:SerializedName("ils")
    val ils: Double? = null,

    @field:SerializedName("idr")
    val idr: Double? = null,

    @field:SerializedName("xrp")
    val xrp: Double? = null,

    @field:SerializedName("try")
    val jsonMemberTry: Double? = null,

    @field:SerializedName("hkd")
    val hkd: Double? = null,

    @field:SerializedName("twd")
    val twd: Double? = null,

    @field:SerializedName("aed")
    val aed: Double? = null,

    @field:SerializedName("eur")
    val eur: Double? = null,

    @field:SerializedName("dkk")
    val dkk: Double? = null,

    @field:SerializedName("bch")
    val bch: Double? = null,

    @field:SerializedName("cad")
    val cad: Double? = null,

    @field:SerializedName("myr")
    val myr: Double? = null,

    @field:SerializedName("dot")
    val dot: Double? = null,

    @field:SerializedName("link")
    val link: Double? = null,

    @field:SerializedName("mmk")
    val mmk: Double? = null,

    @field:SerializedName("nok")
    val nok: Double? = null,

    @field:SerializedName("btc")
    val btc: Double? = null,

    @field:SerializedName("lkr")
    val lkr: Double? = null,

    @field:SerializedName("ngn")
    val ngn: Double? = null,

    @field:SerializedName("czk")
    val czk: Double? = null,

    @field:SerializedName("pkr")
    val pkr: Double? = null,

    @field:SerializedName("sek")
    val sek: Double? = null,

    @field:SerializedName("ltc")
    val ltc: Double? = null,

    @field:SerializedName("uah")
    val uah: Double? = null,

    @field:SerializedName("bhd")
    val bhd: Double? = null,

    @field:SerializedName("ars")
    val ars: Double? = null,

    @field:SerializedName("sar")
    val sar: Double? = null,

    @field:SerializedName("inr")
    val inr: Double? = null,

    @field:SerializedName("cny")
    val cny: Double? = null,

    @field:SerializedName("thb")
    val thb: Double? = null,

    @field:SerializedName("krw")
    val krw: Double? = null,

    @field:SerializedName("jpy")
    val jpy: Double? = null,

    @field:SerializedName("bdt")
    val bdt: Double? = null,

    @field:SerializedName("pln")
    val pln: Double? = null,

    @field:SerializedName("gbp")
    val gbp: Double? = null,

    @field:SerializedName("bmd")
    val bmd: Double? = null,

    @field:SerializedName("huf")
    val huf: Double? = null,

    @field:SerializedName("xlm")
    val xlm: Double? = null,

    @field:SerializedName("sats")
    val sats: Double? = null,

    @field:SerializedName("kwd")
    val kwd: Double? = null,

    @field:SerializedName("php")
    val php: Double? = null,

    @field:SerializedName("yfi")
    val yfi: Double? = null,

    @field:SerializedName("rub")
    val rub: Double? = null
) {
    fun toPrices() = Prices(
        turkishLira = jsonMemberTry ?: 0.0,
        usd = usd ?: 0.0,
        euro = eur ?: 0.0,
    )
}

data class MarketCap(

    @field:SerializedName("usd")
    val usd: Double? = null,

    @field:SerializedName("xdr")
    val xdr: Double? = null,

    @field:SerializedName("eos")
    val eos: Double? = null,

    @field:SerializedName("sgd")
    val sgd: Double? = null,

    @field:SerializedName("vef")
    val vef: Double? = null,

    @field:SerializedName("bnb")
    val bnb: Double? = null,

    @field:SerializedName("eth")
    val eth: Double? = null,

    @field:SerializedName("nzd")
    val nzd: Double? = null,

    @field:SerializedName("brl")
    val brl: Double? = null,

    @field:SerializedName("xag")
    val xag: Double? = null,

    @field:SerializedName("chf")
    val chf: Double? = null,

    @field:SerializedName("mxn")
    val mxn: Double? = null,

    @field:SerializedName("clp")
    val clp: Double? = null,

    @field:SerializedName("bits")
    val bits: Double? = null,

    @field:SerializedName("zar")
    val zar: Double? = null,

    @field:SerializedName("vnd")
    val vnd: Double? = null,

    @field:SerializedName("xau")
    val xau: Double? = null,

    @field:SerializedName("aud")
    val aud: Double? = null,

    @field:SerializedName("ils")
    val ils: Double? = null,

    @field:SerializedName("idr")
    val idr: Double? = null,

    @field:SerializedName("xrp")
    val xrp: Double? = null,

    @field:SerializedName("try")
    val jsonMemberTry: Double? = null,

    @field:SerializedName("hkd")
    val hkd: Double? = null,

    @field:SerializedName("twd")
    val twd: Double? = null,

    @field:SerializedName("aed")
    val aed: Double? = null,

    @field:SerializedName("eur")
    val eur: Double? = null,

    @field:SerializedName("dkk")
    val dkk: Double? = null,

    @field:SerializedName("bch")
    val bch: Double? = null,

    @field:SerializedName("cad")
    val cad: Double? = null,

    @field:SerializedName("myr")
    val myr: Double? = null,

    @field:SerializedName("dot")
    val dot: Double? = null,

    @field:SerializedName("link")
    val link: Double? = null,

    @field:SerializedName("mmk")
    val mmk: Double? = null,

    @field:SerializedName("nok")
    val nok: Double? = null,

    @field:SerializedName("btc")
    val btc: Double? = null,

    @field:SerializedName("lkr")
    val lkr: Double? = null,

    @field:SerializedName("ngn")
    val ngn: Double? = null,

    @field:SerializedName("czk")
    val czk: Double? = null,

    @field:SerializedName("pkr")
    val pkr: Double? = null,

    @field:SerializedName("sek")
    val sek: Double? = null,

    @field:SerializedName("ltc")
    val ltc: Double? = null,

    @field:SerializedName("uah")
    val uah: Double? = null,

    @field:SerializedName("bhd")
    val bhd: Double? = null,

    @field:SerializedName("ars")
    val ars: Double? = null,

    @field:SerializedName("sar")
    val sar: Double? = null,

    @field:SerializedName("inr")
    val inr: Double? = null,

    @field:SerializedName("cny")
    val cny: Double? = null,

    @field:SerializedName("thb")
    val thb: Double? = null,

    @field:SerializedName("krw")
    val krw: Double? = null,

    @field:SerializedName("jpy")
    val jpy: Double? = null,

    @field:SerializedName("bdt")
    val bdt: Double? = null,

    @field:SerializedName("pln")
    val pln: Double? = null,

    @field:SerializedName("gbp")
    val gbp: Double? = null,

    @field:SerializedName("bmd")
    val bmd: Double? = null,

    @field:SerializedName("huf")
    val huf: Double? = null,

    @field:SerializedName("xlm")
    val xlm: Double? = null,

    @field:SerializedName("sats")
    val sats: Double? = null,

    @field:SerializedName("kwd")
    val kwd: Double? = null,

    @field:SerializedName("php")
    val php: Double? = null,

    @field:SerializedName("yfi")
    val yfi: Double? = null,

    @field:SerializedName("rub")
    val rub: Double? = null
)

data class Description(

    @field:SerializedName("de")
    val de: String? = null,

    @field:SerializedName("hi")
    val hi: String? = null,

    @field:SerializedName("no")
    val no: String? = null,

    @field:SerializedName("ru")
    val ru: String? = null,

    @field:SerializedName("fi")
    val fi: String? = null,

    @field:SerializedName("pt")
    val pt: String? = null,

    @field:SerializedName("bg")
    val bg: String? = null,

    @field:SerializedName("lt")
    val lt: String? = null,

    @field:SerializedName("hr")
    val hr: String? = null,

    @field:SerializedName("fr")
    val fr: String? = null,

    @field:SerializedName("hu")
    val hu: String? = null,

    @field:SerializedName("uk")
    val uk: String? = null,

    @field:SerializedName("sk")
    val sk: String? = null,

    @field:SerializedName("sl")
    val sl: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("sv")
    val sv: String? = null,

    @field:SerializedName("ko")
    val ko: String? = null,

    @field:SerializedName("zh-tw")
    val zhTw: String? = null,

    @field:SerializedName("el")
    val el: String? = null,

    @field:SerializedName("en")
    val en: String? = null,

    @field:SerializedName("it")
    val it: String? = null,

    @field:SerializedName("es")
    val es: String? = null,

    @field:SerializedName("zh")
    val zh: String? = null,

    @field:SerializedName("cs")
    val cs: String? = null,

    @field:SerializedName("ar")
    val ar: String? = null,

    @field:SerializedName("vi")
    val vi: String? = null,

    @field:SerializedName("th")
    val th: String? = null,

    @field:SerializedName("ja")
    val ja: String? = null,

    @field:SerializedName("pl")
    val pl: String? = null,

    @field:SerializedName("ro")
    val ro: String? = null,

    @field:SerializedName("da")
    val da: String? = null,

    @field:SerializedName("he")
    val he: String? = null,

    @field:SerializedName("nl")
    val nl: String? = null,

    @field:SerializedName("tr")
    val tr: String? = null
)

data class AtlDate(

    @field:SerializedName("usd")
    val usd: String? = null,

    @field:SerializedName("xdr")
    val xdr: String? = null,

    @field:SerializedName("eos")
    val eos: String? = null,

    @field:SerializedName("sgd")
    val sgd: String? = null,

    @field:SerializedName("vef")
    val vef: String? = null,

    @field:SerializedName("bnb")
    val bnb: String? = null,

    @field:SerializedName("eth")
    val eth: String? = null,

    @field:SerializedName("nzd")
    val nzd: String? = null,

    @field:SerializedName("brl")
    val brl: String? = null,

    @field:SerializedName("xag")
    val xag: String? = null,

    @field:SerializedName("chf")
    val chf: String? = null,

    @field:SerializedName("mxn")
    val mxn: String? = null,

    @field:SerializedName("clp")
    val clp: String? = null,

    @field:SerializedName("bits")
    val bits: String? = null,

    @field:SerializedName("zar")
    val zar: String? = null,

    @field:SerializedName("vnd")
    val vnd: String? = null,

    @field:SerializedName("xau")
    val xau: String? = null,

    @field:SerializedName("aud")
    val aud: String? = null,

    @field:SerializedName("ils")
    val ils: String? = null,

    @field:SerializedName("idr")
    val idr: String? = null,

    @field:SerializedName("xrp")
    val xrp: String? = null,

    @field:SerializedName("try")
    val jsonMemberTry: String? = null,

    @field:SerializedName("hkd")
    val hkd: String? = null,

    @field:SerializedName("twd")
    val twd: String? = null,

    @field:SerializedName("aed")
    val aed: String? = null,

    @field:SerializedName("eur")
    val eur: String? = null,

    @field:SerializedName("dkk")
    val dkk: String? = null,

    @field:SerializedName("bch")
    val bch: String? = null,

    @field:SerializedName("cad")
    val cad: String? = null,

    @field:SerializedName("myr")
    val myr: String? = null,

    @field:SerializedName("dot")
    val dot: String? = null,

    @field:SerializedName("link")
    val link: String? = null,

    @field:SerializedName("mmk")
    val mmk: String? = null,

    @field:SerializedName("nok")
    val nok: String? = null,

    @field:SerializedName("btc")
    val btc: String? = null,

    @field:SerializedName("lkr")
    val lkr: String? = null,

    @field:SerializedName("ngn")
    val ngn: String? = null,

    @field:SerializedName("czk")
    val czk: String? = null,

    @field:SerializedName("pkr")
    val pkr: String? = null,

    @field:SerializedName("sek")
    val sek: String? = null,

    @field:SerializedName("ltc")
    val ltc: String? = null,

    @field:SerializedName("uah")
    val uah: String? = null,

    @field:SerializedName("bhd")
    val bhd: String? = null,

    @field:SerializedName("ars")
    val ars: String? = null,

    @field:SerializedName("sar")
    val sar: String? = null,

    @field:SerializedName("inr")
    val inr: String? = null,

    @field:SerializedName("cny")
    val cny: String? = null,

    @field:SerializedName("thb")
    val thb: String? = null,

    @field:SerializedName("krw")
    val krw: String? = null,

    @field:SerializedName("jpy")
    val jpy: String? = null,

    @field:SerializedName("bdt")
    val bdt: String? = null,

    @field:SerializedName("pln")
    val pln: String? = null,

    @field:SerializedName("gbp")
    val gbp: String? = null,

    @field:SerializedName("bmd")
    val bmd: String? = null,

    @field:SerializedName("huf")
    val huf: String? = null,

    @field:SerializedName("xlm")
    val xlm: String? = null,

    @field:SerializedName("sats")
    val sats: String? = null,

    @field:SerializedName("kwd")
    val kwd: String? = null,

    @field:SerializedName("php")
    val php: String? = null,

    @field:SerializedName("yfi")
    val yfi: String? = null,

    @field:SerializedName("rub")
    val rub: String? = null
)

data class Localization(

    @field:SerializedName("de")
    val de: String? = null,

    @field:SerializedName("hi")
    val hi: String? = null,

    @field:SerializedName("no")
    val no: String? = null,

    @field:SerializedName("ru")
    val ru: String? = null,

    @field:SerializedName("fi")
    val fi: String? = null,

    @field:SerializedName("pt")
    val pt: String? = null,

    @field:SerializedName("bg")
    val bg: String? = null,

    @field:SerializedName("lt")
    val lt: String? = null,

    @field:SerializedName("hr")
    val hr: String? = null,

    @field:SerializedName("fr")
    val fr: String? = null,

    @field:SerializedName("hu")
    val hu: String? = null,

    @field:SerializedName("uk")
    val uk: String? = null,

    @field:SerializedName("sk")
    val sk: String? = null,

    @field:SerializedName("sl")
    val sl: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("sv")
    val sv: String? = null,

    @field:SerializedName("ko")
    val ko: String? = null,

    @field:SerializedName("zh-tw")
    val zhTw: String? = null,

    @field:SerializedName("el")
    val el: String? = null,

    @field:SerializedName("en")
    val en: String? = null,

    @field:SerializedName("it")
    val it: String? = null,

    @field:SerializedName("es")
    val es: String? = null,

    @field:SerializedName("zh")
    val zh: String? = null,

    @field:SerializedName("cs")
    val cs: String? = null,

    @field:SerializedName("ar")
    val ar: String? = null,

    @field:SerializedName("vi")
    val vi: String? = null,

    @field:SerializedName("th")
    val th: String? = null,

    @field:SerializedName("ja")
    val ja: String? = null,

    @field:SerializedName("pl")
    val pl: String? = null,

    @field:SerializedName("ro")
    val ro: String? = null,

    @field:SerializedName("da")
    val da: String? = null,

    @field:SerializedName("he")
    val he: String? = null,

    @field:SerializedName("nl")
    val nl: String? = null,

    @field:SerializedName("tr")
    val tr: String? = null
)

data class Image(

    @field:SerializedName("small")
    val small: String? = null,

    @field:SerializedName("large")
    val large: String? = null,

    @field:SerializedName("thumb")
    val thumb: String? = null
)
