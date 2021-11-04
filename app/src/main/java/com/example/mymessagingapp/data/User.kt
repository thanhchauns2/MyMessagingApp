package com.example.mymessagingapp.data

import java.io.Serializable
import java.util.*

data class User(val userId : String,
                var name : String,
                var password : String,
                val gmail : String,
                val dateOfBirth : Date,
                val accountCreate : Date,
                var image : String,
                var isActive : Boolean,
                var group_list_id : List<String>,
                var fcm_token : List<String>) : Serializable{
}