package com.example.homework10_leacture13

data class Component(val type:Int, val id:Int,val icon:Icon) {
}

enum class Icon(val iconName:String){
    PROFILE("Edit Profile"),
    LOCATION("Address"),
    BELL("Notification"),
    WALLET("Payment"),
    SECURITY("Security"),
    LANGUAGE("Language"),
    MODE("Dark Mode"),
    LOCK("Privacy Policy"),
    HELP("Help Center"),
    FRIENDS("Invite Friend"),
    LOGOUT("Logout")
}