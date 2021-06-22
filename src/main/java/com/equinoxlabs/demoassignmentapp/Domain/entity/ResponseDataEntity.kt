package com.equinoxlabs.demoassignmentapp.Domain.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class DataResponseEntity:Serializable {
    @SerializedName("CODE")
    @Expose
    var code: String? = null

    @SerializedName("DATA")
    @Expose
    var data: List<DataE>? = null

    @SerializedName("MESSAGE")
    @Expose
    var message: String? = null
}
@Entity(tableName = "usertable")
class DataE: Serializable {
    @SerializedName("TODAYS_COUNT")
    @Expose
    var todaysCount: Int? = null

    @SerializedName("age")
    @Expose
    var age: String? = null

    @SerializedName("created_on")
    @Expose
    var createdOn: String? = null

    @SerializedName("dept_id")
    @Expose
    var deptId: String? = null

    @SerializedName("dept_name")
    @Expose
    var deptName: String? = null

    @SerializedName("email_id")
    @Expose
    var emailId: String? = null

    @SerializedName("gender")
    @Expose
    var gender: String? = null

    @SerializedName("is_deleted")
    @Expose
    var isDeleted: Boolean? = null

    @SerializedName("mobile")
    @Expose
    var mobile: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("password")
    @Expose
    var password: String? = null

    @SerializedName("profile_img")
    @Expose
    var profileImg: String? = null

    @SerializedName("reporting_to_id")
    @Expose
    var reportingToId: Int? = null

    @SerializedName("reporting_to_name")
    @Expose
    var reportingToName: String? = null

    @SerializedName("role_id")
    @Expose
    var roleId: String? = null

    @SerializedName("role_name")
    @Expose
    var roleName: String? = null

    @SerializedName("token")
    @Expose
    var token: String? = null

    @SerializedName("updated_on")
    @Expose
    var updatedOn: String? = null
//
    @PrimaryKey
    @NonNull
    @SerializedName("user_id")
    @Expose
    var userId : String? = null

}