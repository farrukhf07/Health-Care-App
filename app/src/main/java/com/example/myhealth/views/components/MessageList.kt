package com.example.myhealth.views.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myhealth.R
import com.example.myhealth.model.MessageModel
import com.example.myhealth.ui.theme.Purple80

@Composable
fun MessageList(modifier: Modifier = Modifier, messageList : List<MessageModel>) {
    if(messageList.isEmpty()){
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.size(60.dp),
                painter = painterResource(id = R.drawable.baseline_question_answer_24),
                contentDescription = "Icon",
                tint = Purple80,
            )
            Text(text = "Ask me anything", fontSize = 22.sp)
        }
    }else{
        LazyColumn(
            modifier = modifier,
            reverseLayout = true
        ) {
            items(messageList.reversed()){
                MessageView(messageModel = it)
            }
        }
    }

}