package com.ahmetozaydin.ecommerceapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BaseClass(
    @SerializedName("products") val products: List<Product>? = null,
    @SerializedName("total") val total: Int? = null,
    @SerializedName("skip") val skip: Int? = null,
    @SerializedName("limit") val limit: Int? = null
) : Parcelable

@Parcelize
data class Product(
    @SerializedName("id") val id: Int? = null,//named as productId, productName... and productList --> products
    @SerializedName("title") val title: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("price") val price: Int? = null,
    @SerializedName("discountPercentage") val discountPercentage: Double? = null,
    @SerializedName("rating") val rating: Double? = null,
    @SerializedName("stock") val stock: Int? = null,
    @SerializedName("brand") val brand: String? = null,
    @SerializedName("category") val category: String? = null,
    @SerializedName("thumbnail") val thumbnail: String? = null,
    @SerializedName("images") val images: List<String>? = null
) : Parcelable

//@Parcelize
//data class BaseClass2 (
//    @SerializedName("findItemsAdvancedResponse" ) var findItemsAdvancedResponse : ArrayList<FindItemsAdvancedResponse> = arrayListOf()
//
//) : Parcelable
//@Parcelize
//data class PrimaryCategory (
//
//    @SerializedName("categoryId"   ) var categoryId   : ArrayList<String> = arrayListOf(),
//    @SerializedName("categoryName" ) var categoryName : ArrayList<String> = arrayListOf()
//
//) : Parcelable
//
//@Parcelize
//data class ProductId (
//
//    @SerializedName("@type"     ) var type   : String? = null,
//    @SerializedName("__value__" ) var _value_ : String? = null
//) : Parcelable
//
//@Parcelize
//data class SellerInfo (
//
//    @SerializedName("sellerUserName"          ) var sellerUserName          : ArrayList<String> = arrayListOf(),
//    @SerializedName("feedbackScore"           ) var feedbackScore           : ArrayList<String> = arrayListOf(),
//    @SerializedName("positiveFeedbackPercent" ) var positiveFeedbackPercent : ArrayList<String> = arrayListOf(),
//    @SerializedName("feedbackRatingStar"      ) var feedbackRatingStar      : ArrayList<String> = arrayListOf(),
//    @SerializedName("topRatedSeller"          ) var topRatedSeller          : ArrayList<String> = arrayListOf()
//
//) : Parcelable
//
//@Parcelize
//data class ShippingServiceCost (
//
//    @SerializedName("@currencyId" ) var currencyId : String? = null,
//    @SerializedName("__value__"   ) var _value_     : String? = null
//) : Parcelable
//
//@Parcelize
//data class ShippingInfo (
//
//    @SerializedName("shippingServiceCost"     ) var shippingServiceCost     : ArrayList<ShippingServiceCost> = arrayListOf(),
//    @SerializedName("shippingType"            ) var shippingType            : ArrayList<String>              = arrayListOf(),
//    @SerializedName("shipToLocations"         ) var shipToLocations         : ArrayList<String>              = arrayListOf(),
//    @SerializedName("expeditedShipping"       ) var expeditedShipping       : ArrayList<String>              = arrayListOf(),
//    @SerializedName("oneDayShippingAvailable" ) var oneDayShippingAvailable : ArrayList<String>              = arrayListOf(),
//    @SerializedName("handlingTime"            ) var handlingTime            : ArrayList<String>              = arrayListOf()
//) : Parcelable
//
//@Parcelize
//data class CurrentPrice (
//
//    @SerializedName("@currencyId" ) var currencyId : String? = null,
//    @SerializedName("__value__"   ) var _value_     : String? = null
//) : Parcelable
//
//@Parcelize
//data class ConvertedCurrentPrice (
//
//    @SerializedName("@currencyId" ) var currencyId : String? = null,
//    @SerializedName("__value__"   ) var _value_     : String? = null
//) : Parcelable
//
//@Parcelize
//data class SellingStatus (
//
//    @SerializedName("currentPrice"          ) var currentPrice          : ArrayList<CurrentPrice>          = arrayListOf(),
//    @SerializedName("convertedCurrentPrice" ) var convertedCurrentPrice : ArrayList<ConvertedCurrentPrice> = arrayListOf(),
//    @SerializedName("sellingState"          ) var sellingState          : ArrayList<String>                = arrayListOf(),
//    @SerializedName("timeLeft"              ) var timeLeft              : ArrayList<String>                = arrayListOf()
//
//) : Parcelable
//
//@Parcelize
//data class ListingInfo (
//
//    @SerializedName("bestOfferEnabled"  ) var bestOfferEnabled  : ArrayList<String> = arrayListOf(),
//    @SerializedName("buyItNowAvailable" ) var buyItNowAvailable : ArrayList<String> = arrayListOf(),
//    @SerializedName("startTime"         ) var startTime         : String?           = null,
//    @SerializedName("endTime"           ) var endTime           : String?           = null,
//    @SerializedName("listingType"       ) var listingType       : ArrayList<String> = arrayListOf(),
//    @SerializedName("gift"              ) var gift              : ArrayList<String> = arrayListOf(),
//    @SerializedName("watchCount"        ) var watchCount        : ArrayList<String> = arrayListOf()
//
//) : Parcelable
//
//@Parcelize
//data class Distance (
//
//    @SerializedName("@unit"     ) var unit   : String? = null,
//    @SerializedName("__value__" ) var _value_ : String? = null
//
//) : Parcelable
//
//@Parcelize
//data class Condition (
//
//    @SerializedName("conditionId"          ) var conditionId          : ArrayList<String> = arrayListOf(),
//    @SerializedName("conditionDisplayName" ) var conditionDisplayName : ArrayList<String> = arrayListOf()
//
//): Parcelable
//
//@Parcelize
//data class Item (
//
//    @SerializedName("itemId"                  ) var itemId                  : ArrayList<String>          = arrayListOf(),
//    @SerializedName("title"                   ) var title                   : ArrayList<String>          = arrayListOf(),
//    @SerializedName("globalId"                ) var globalId                : ArrayList<String>          = arrayListOf(),
//    @SerializedName("primaryCategory"         ) var primaryCategory         : ArrayList<PrimaryCategory> = arrayListOf(),
//    @SerializedName("galleryURL"              ) var galleryURL              : ArrayList<String>          = arrayListOf(),
//    @SerializedName("viewItemURL"             ) var viewItemURL             : ArrayList<String>          = arrayListOf(),
//    @SerializedName("productId"               ) var productId               : ArrayList<ProductId>       = arrayListOf(),
//    @SerializedName("autoPay"                 ) var autoPay                 : ArrayList<String>          = arrayListOf(),
//    @SerializedName("postalCode"              ) var postalCode              : String?                    = null,
//    @SerializedName("location"                ) var location                : ArrayList<String>          = arrayListOf(),
//    @SerializedName("country"                 ) var country                 : ArrayList<String>          = arrayListOf(),
//    @SerializedName("sellerInfo"              ) var sellerInfo              : ArrayList<SellerInfo>      = arrayListOf(),
//    @SerializedName("shippingInfo"            ) var shippingInfo            : ArrayList<ShippingInfo>    = arrayListOf(),
//    @SerializedName("sellingStatus"           ) var sellingStatus           : ArrayList<SellingStatus>   = arrayListOf(),
//    @SerializedName("listingInfo"             ) var listingInfo             : ArrayList<ListingInfo>     = arrayListOf(),
//    @SerializedName("returnsAccepted"         ) var returnsAccepted         : ArrayList<String>          = arrayListOf(),
//    @SerializedName("distance"                ) var distance                : ArrayList<Distance>        = arrayListOf(),
//    @SerializedName("condition"               ) var condition               : ArrayList<Condition>       = arrayListOf(),
//    @SerializedName("isMultiVariationListing" ) var isMultiVariationListing : ArrayList<String>          = arrayListOf(),
//    @SerializedName("topRatedListing"         ) var topRatedListing         : ArrayList<String>          = arrayListOf()
//
//) : Parcelable
//
//@Parcelize
//data class SearchResult (
//
//    @SerializedName("@count" ) var count : String?         = null,
//    @SerializedName("item"   ) var item   : ArrayList<Item> = arrayListOf()
//
//) : Parcelable
//
//@Parcelize
//data class PaginationOutput (
//
//    @SerializedName("pageNumber"     ) var pageNumber     : ArrayList<String> = arrayListOf(),
//    @SerializedName("entriesPerPage" ) var entriesPerPage : ArrayList<String> = arrayListOf(),
//    @SerializedName("totalPages"     ) var totalPages     : ArrayList<String> = arrayListOf(),
//    @SerializedName("totalEntries"   ) var totalEntries   : ArrayList<String> = arrayListOf()
//
//) : Parcelable
//
//@Parcelize
//data class FindItemsAdvancedResponse (
//
//    @SerializedName("ack"              ) var ack              : ArrayList<String>           = arrayListOf(),
//    @SerializedName("version"          ) var version          : String?                     = null,
//    @SerializedName("timestamp"        ) var timestamp        : String?                     = null,
//    @SerializedName("searchResult"     ) var searchResult     : ArrayList<SearchResult>     = arrayListOf(),
//    @SerializedName("paginationOutput" ) var paginationOutput : ArrayList<PaginationOutput> = arrayListOf(),
//    @SerializedName("itemSearchURL"    ) var itemSearchURL    : ArrayList<String>           = arrayListOf()
//
//) : Parcelable
