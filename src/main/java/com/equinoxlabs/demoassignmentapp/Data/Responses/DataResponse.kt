package com.equinoxlabs.demoassignmentapp.Data.Responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class DataResponse:Serializable {
    @SerializedName("CODE")
    @Expose
   var code: String? = null

    @SerializedName("DATA")
    @Expose
   var data: List<DataR>? = null

    @SerializedName("MESSAGE")
    @Expose
   var message: String? = null
}
class DataR:Serializable{
    @SerializedName("TODAYS_COUNT")
    @Expose
   var todaysCount: Any? = null

    @SerializedName("age")
    @Expose
   var age: String? = null

    @SerializedName("created_on")
    @Expose
   var createdOn: Any? = null

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
   var isDeleted: Any? = null

    @SerializedName("mobile")
    @Expose
   var mobile: String? = null

    @SerializedName("name")
    @Expose
   var name: String? = null

    @SerializedName("password")
    @Expose
   var password: Any? = null

    @SerializedName("profile_img")
    @Expose
   var profileImg: Any? = null

    @SerializedName("reporting_to_id")
    @Expose
   var reportingToId: Any? = null

    @SerializedName("reporting_to_name")
    @Expose
   var reportingToName: Any? = null

    @SerializedName("role_id")
    @Expose
   var roleId: Any? = null

    @SerializedName("role_name")
    @Expose
   var roleName: Any? = null

    @SerializedName("token")
    @Expose
   var token: Any? = null

    @SerializedName("updated_on")
    @Expose
   var updatedOn: Any? = null

    @SerializedName("user_id")
    @Expose
   var userId: String? = null

}