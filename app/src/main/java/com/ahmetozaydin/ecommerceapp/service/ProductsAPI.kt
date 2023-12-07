package com.ahmetozaydin.ecommerceapp.service

import com.ahmetozaydin.ecommerceapp.model.BaseClass
import com.ahmetozaydin.ecommerceapp.model.Product
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ProductsAPI {

    @GET("products?limit=100") //extension
    fun getData() : Call<BaseClass>
    @GET("findingService/keywords=iphone&buyerPostalCode=90007&itemFilter(0).name=MaxDistance&itemFilter(0).value=10&itemFilter(1).name=FreeShippingOnly&itemFilter(1).value=false&itemFilter(2).name=LocalPickupOnly&itemFilter(2).value=false&itemFilter(3).name=HideDuplicateItems&itemFilter(3).value=true&itemFilter(4).name=Condition&itemFilter(4).value(0)=New&itemFilter(4).value(1)=Used&itemFilter(4).value(2)=Unspecified&outputSelector(0)=SellerInfo&outputSelector(1)=StoreInfo") //extension
    fun getData2() : Call<BaseClass>
    @GET
    fun getCategorizedProduct(@Url text : String) : Call<BaseClass>
    @GET("categories")
    fun getCategoryFromAPI() : Single<List<String>>
    @GET("smartphones")
    fun getSmartPhonesFromAPI() : Single<BaseClass>
}