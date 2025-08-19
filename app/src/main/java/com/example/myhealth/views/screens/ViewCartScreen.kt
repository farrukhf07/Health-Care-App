package com.example.myhealth.views.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myhealth.model.PlaceOrder
import com.example.myhealth.ui.theme.black
import com.example.myhealth.ui.theme.lightBlueBackground
import com.example.myhealth.ui.theme.navyBlue
import com.example.myhealth.ui.theme.white
import com.example.myhealth.utils.AppUtil
import com.example.myhealth.utils.CART_TABLE
import com.example.myhealth.utils.PLACE_ORDER
import com.example.myhealth.viewModel.MedicineListVm
import com.example.myhealth.viewModel.ViewCartVM
import com.example.myhealth.views.components.CartLabTestView
import com.example.myhealth.views.components.CartMedicineView
import com.example.myhealth.views.components.CustomTextField
import com.example.myhealth.views.components.MedicineView
import kotlin.random.Random

@Composable
fun ViewCartScreen() {
    val context = LocalContext.current
    val viewModel: ViewCartVM = hiltViewModel()
    val cartItem by viewModel.cartItem
    val cartLabItem by viewModel.cartLabItem
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(lightBlueBackground)
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Your Cart Items",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp)
                .weight(1f)
        ) {
            Text(text = "Medicines List",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(5.dp))
            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)) {
                items(cartItem) {cartItem->
                    var quantity by remember {mutableStateOf(cartItem.quantity)}
                    var totalPrice by remember { mutableStateOf(cartItem.total_price) }
                    CartMedicineView(
                        medicineName = cartItem.medicine_name,
                        medicinePrice = cartItem.total_price,
                        medicineQuantity = quantity?:0,
                        btnMinusMed = {
                                      if (quantity > 1){
                                          quantity = quantity - 1
                                          totalPrice = cartItem.price * quantity
                                          cartItem.total_price = totalPrice
                                      }
                        },
                        btnPlusMed = {
                                     if(quantity < 3){
                                         quantity += 1
                                         totalPrice = cartItem.price * quantity
                                         cartItem.total_price = totalPrice
                                     }
                        },
                        deleteMed = {
                            viewModel.deleteCartItem(cartItem.id)
                        },
                        confirmOrder = {
                            val id = Random.nextInt(1, 1000)
                            val placeOrder = PlaceOrder(
                                id = id,
                                user_id = AppUtil.getPatient()?.id ?: 0,
                                medicine_id = cartItem.medicine_id,
                                price = cartItem.price,
                                total_price = totalPrice,
                                quantity = quantity
                            )
                            PLACE_ORDER.child("${id}").setValue(placeOrder).addOnSuccessListener {
                                Toast.makeText(context, "Order is Confirmed!", Toast.LENGTH_SHORT).show()
                            }.addOnFailureListener {
                                Toast.makeText(context, "You are Shortly Served!", Toast.LENGTH_SHORT).show()
                            }
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "List of Tests",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(5.dp))
            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)) {
                items(cartLabItem) {cartLabItem->
                    CartLabTestView(
                        name = cartLabItem.test_name,
                        price = cartLabItem.price,
                        deleteTest = {viewModel.deleteCartLabItem(cartLabItem.id)},
                        confirmOrder = {
                            val id = Random.nextInt(1001,2000)
                            val placeOrder = PlaceOrder(
                                id = id,
                                user_id = AppUtil.getPatient()?.id ?: 0,
                                test_id = cartLabItem.test_id,
                                price = cartLabItem.price
                            )
                            PLACE_ORDER.child("${id}").setValue(placeOrder).addOnSuccessListener {
                                Toast.makeText(context, "Order is Confirmed!", Toast.LENGTH_SHORT).show()
                            }.addOnFailureListener {
                                Toast.makeText(context, "You are Shortly Served!", Toast.LENGTH_SHORT).show()
                            }
                        }
                    )
                }
            }
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 25.dp)
//            ) {
//                Button(
//                    onClick = { },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(5.dp),
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = navyBlue,
//                        contentColor = white
//                    ),
//                    shape = RectangleShape
//                ) {
//                    Text(
//                        text = "Proceed",
//                        fontSize = 18.sp,
//                        fontWeight = FontWeight.SemiBold
//                    )
//                }
//            }
        }
    }
}

@Preview
@Composable
fun ShowViewCartScreen() {
    ViewCartScreen()
}