package com.go2future.tuvoclient.data.local

import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class AppTextDbModel {
    @SerializedName("TextTitle")
    @Expose
    var TextTitle: String? = null

    @SerializedName("ApplicationText")
    @Expose
    var ApplicationText: String? = null

    @PrimaryKey
    @SerializedName("ApplicationTextId")
    @Expose
    var ApplicationTextId: Int? = null

    @SerializedName("ApplicationTextCode")
    @Expose
    var ApplicationTextCode: String? = null

}
