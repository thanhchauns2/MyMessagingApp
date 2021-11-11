package com.example.mymessagingapp.adapter

import androidx.recyclerview.widget.SortedListAdapterCallback
import com.example.mymessagingapp.data.Conversation

class SortedListConversationAdapter(adapter: ConversationAdapter) : SortedListAdapterCallback<Conversation>( adapter) {
    override fun compare(con1 : Conversation?, con2: Conversation?): Int {
            return -con1!!.timeSend.compareTo(con2!!.timeSend)
    }

    override fun areContentsTheSame(oldItem: Conversation?, newItem: Conversation?): Boolean {
        return oldItem?.senderName.equals(newItem?.senderName) == true && oldItem?.timeSend?.equals(newItem?.timeSend) == true
    }

    override fun areItemsTheSame(item1: Conversation?, item2: Conversation?): Boolean {
        return item1?.groupId.equals(item2?.groupId)
    }
}