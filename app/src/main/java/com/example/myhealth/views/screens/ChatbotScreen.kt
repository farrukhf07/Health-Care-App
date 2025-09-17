package com.example.myhealth.views.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myhealth.viewModel.ChatbotVM
import com.example.myhealth.views.components.InputMessage
import com.example.myhealth.views.components.MessageHeader
import com.example.myhealth.views.components.MessageList


@Composable
fun ChatbotScreen(modifier: Modifier = Modifier, viewModel: ChatbotVM = hiltViewModel()) {
    Column(
        modifier = modifier
    ) {
        MessageHeader()
        MessageList(
            modifier = Modifier.weight(1f),
            messageList = viewModel.messageList
        )
        InputMessage(
            onMessageSend = {
                viewModel.sendMessage(it)
            }
        )
    }
}