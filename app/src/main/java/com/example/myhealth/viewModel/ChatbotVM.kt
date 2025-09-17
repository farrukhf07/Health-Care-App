package com.example.myhealth.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhealth.model.MessageModel
import com.example.myhealth.utils.API_KEY
import com.example.myhealth.utils.MODEL_NAME
import com.example.myhealth.utils.USER
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.launch

class ChatbotVM:ViewModel() {
    val messageList by lazy{
        mutableStateListOf<MessageModel>()
    }

    val generativeModel: GenerativeModel = GenerativeModel(
        modelName = MODEL_NAME,
        apiKey = API_KEY
    )

    fun sendMessage(question: String){
        viewModelScope.launch{
            try {
                val chat = generativeModel.startChat(
//                    history = messageList.map {
//                        content(it.role){text(it.message)}
//                    }.toList()
                )
                messageList.add(MessageModel(question, USER))
                messageList.add(MessageModel("Typing...", MODEL_NAME))
                val response = chat.sendMessage(question)
                messageList.removeLast()
                messageList.add(MessageModel(response.text.toString(), MODEL_NAME))
            } catch (e: Exception){
                messageList.removeLast()
                messageList.add(MessageModel("Error: ${e.message}","model"))
            }
        }
    }
}