package com.example.myhealth.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myhealth.model.CartLabTable
import com.example.myhealth.model.CartTable
import com.example.myhealth.model.Medicine
import com.example.myhealth.utils.AppUtil
import com.example.myhealth.utils.CART_LAB_TABLE
import com.example.myhealth.utils.CART_TABLE
import com.example.myhealth.utils.DATABASE
import com.example.myhealth.utils.MEDICINE_TABLE
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import javax.inject.Inject

class ViewCartVM @Inject constructor(
    savedStateHandle: SavedStateHandle
):ViewModel(){
    private val _cartItem = mutableStateOf<List<CartTable>>(emptyList())
    val cartItem: State<List<CartTable>> = _cartItem

    init {
        fetchCartItem()
        fetchLabCartItem()
    }

    fun fetchCartItem(){
        val cartList = mutableListOf<CartTable>()
        CART_TABLE.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (items in snapshot.children){
                    val item = items.getValue(CartTable::class.java)
                    if(item != null && item.user_id == AppUtil.getPatient()?.id){
                        cartList.add(item)
                    }
                }
                _cartItem.value = cartList
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Database", error.message)
            }

        })
    }
    private val _cartLabItem = mutableStateOf<List<CartLabTable>>(emptyList())
    val cartLabItem: State<List<CartLabTable>> = _cartLabItem
    fun fetchLabCartItem(){
        val cartLabList = mutableListOf<CartLabTable>()
        CART_LAB_TABLE.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (labItems in snapshot.children){
                    val labItem = labItems.getValue(CartLabTable::class.java)
                    if (labItem != null && labItem.user_id == AppUtil.getPatient()?.id){
                        cartLabList.add(labItem)
                    }
                }
                _cartLabItem.value = cartLabList
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Database", error.message)
            }

        })
    }

    fun deleteCartItem(id: Int){
        CART_TABLE.orderByChild("id").equalTo(id.toDouble()).addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (itemSnapshot in snapshot.children){
                        itemSnapshot.ref.removeValue().addOnSuccessListener {
                            fetchCartItem()
                            Log.d("cart", "Cart item deleted successfully")
                        }.addOnFailureListener {
                            Log.d("cart", "Error to delete item")
                        }
                    }
                } else{
                    Log.d("cart","Item id $id not found")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("database", error.message)
            }

        })
    }
    fun deleteCartLabItem(id: Int){
        CART_LAB_TABLE.orderByChild("id").equalTo(id.toDouble()).addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (labSnapshot in snapshot.children){
                        labSnapshot.ref.removeValue().addOnSuccessListener {
                            fetchLabCartItem()
                            Log.d("cart", "Cart item deleted successfully")
                        }.addOnFailureListener {
                            Log.d("cart", "Error to delete item")
                        }
                    }
                }else{
                    Log.d("cart", "Item id $id not found")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("database", error.message)
            }

        })
    }

}