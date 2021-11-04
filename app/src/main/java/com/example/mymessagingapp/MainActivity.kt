package com.example.mymessagingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.messapp.R
import com.example.mymessagingapp.data.Group
import com.example.mymessagingapp.data.User
import com.example.mymessagingapp.interfaces.CallBackFromChatList
import com.example.mymessagingapp.interfaces.CallBackFromListUserFound
import com.example.mymessagingapp.interfaces.CallBackWhenGroupExisted
import java.util.*

class MainActivity : AppCompatActivity(), CallBackFromChatList, CallBackFromListUserFound, CallBackWhenGroupExisted{
    private var user : User = User("123","tien", "123456789", "dmcsncc19@gmail.com"
        , Date(),Date(),CONSTANT.IMAGE_DEFAULT, false,
        emptyList(), emptyList())
    override fun onCreate(savedInstanceState: Bundle?) {70
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val currentFragment =supportFragmentManager.findFragmentById(R.id.fragment_container)
        if(currentFragment == null){
            val chatListFragment = ChatListFragment.newInstance(user)
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, chatListFragment).commit()
        }
    }
    fun onUserLogin(user : User){

    }
    override fun onGroupSelected(user : User, group : Group){
        val chatFragment = ChatFragment.newInstance(user, group)
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, chatFragment).commit()
    }

    override fun onUserFound(userFound: User) {
        val group = Group(UUID.randomUUID().toString(), userFound.name, Date(), listOf(user.userId, userFound.userId), false, CONSTANT.IMAGE_DEFAULT)
        val chatFragment = ChatFragment.newInstance(user, group)
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, chatFragment).commit()
    }

    override fun onGroupExist( group: Group) {
        val chatFragment = ChatFragment.newInstance(user, group)
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, chatFragment).commit()
    }
}