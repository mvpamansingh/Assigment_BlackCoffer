@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)

package com.example.assignment

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DropdownMenu() {

    var isExpanded by remember { mutableStateOf(false) }

    var gender by remember { mutableStateOf("") }

    val genderList = listOf(" Available | Hey Let Us Connect", "Away | Stay Discrete And Watch", "Busy | Do Not Disturb | Will Carch Up Later", "SOS | Emergency! Need Assistance! HELP")

    ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = { isExpanded = it }) {

        OutlinedTextField(
            value = genderList[0],
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
            },
            colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(),
           modifier = Modifier
               .menuAnchor()
               .width(351.dp),
            shape = RoundedCornerShape(10.dp),
        )

        ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
            genderList.forEach {
                DropdownMenuItem(text = { Text(text = it) }, onClick = {
                    gender = it
                    isExpanded = false
                })
            }


        }

    }
}

@Composable
fun SliderWithValueDisplay() {
    var sliderPosition by remember { mutableStateOf(50f) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            //.padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(bottom = 1.dp)
            ) {
                Text(
                    text = sliderPosition.toInt().toString(),
                    fontSize = 14.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .background(Color(0xFF01579B))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                valueRange = 1f..100f,
                steps = 0,
                modifier = Modifier.fillMaxWidth(),
                colors = SliderDefaults.colors(thumbColor = Color(0xFF01579B), activeTrackColor =Color(0xFF01579B))
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "1 Km", fontSize = 12.sp, modifier = Modifier.padding(start = 10.dp))
                Text(text = "100 Km", fontSize = 12.sp, modifier = Modifier.padding(end = 11.dp))
            }
        }
    }
}
@Composable
fun SelectableOptions() {
    val options = listOf("Coffee", "Business", "Hobbies", "Friendship", "Movies", "Dining", "Dating", "Matrimony")
    var selectedOptions by remember { mutableStateOf(setOf<String>()) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Select Purpose",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        // Define spacing
        val horizontalSpacing = 3.dp
        val verticalSpacing = 4.dp

        // Use a LazyVerticalGrid
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = verticalSpacing),
            contentPadding = PaddingValues(horizontal = horizontalSpacing)
        ) {
            items(options.size) { index ->
                val option = options[index]
                val isSelected = selectedOptions.contains(option)
                Button(
                    onClick = {
                        selectedOptions = if (isSelected) {
                            selectedOptions - option
                        } else {
                            selectedOptions + option
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSelected) Color(0xFF01579B) else Color.White,
                        contentColor = if (isSelected) Color.White else Color(0xFF01579B)
                    ),
                    shape = RoundedCornerShape(50),
                    border = BorderStroke(1.dp, Color(0xFF01579B)),
                    modifier = Modifier
                        .padding(horizontal = horizontalSpacing / 2, vertical = verticalSpacing / 2)
                        .fillMaxWidth()
                ) {
                    Text(text = option,modifier= Modifier.weight(2f), fontSize = 10.sp, maxLines = 1,)
                }
            }
        }
    }
}


// Refine Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RefineScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Refine", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back action */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF01579B)
                )            )
        }
    ) {
        var status by remember  {mutableStateOf("Hi Community! I am open to new connections" )}

        Column(
            modifier= Modifier.fillMaxSize()
            ,horizontalAlignment = Alignment.CenterHorizontally,

        ) {

            Spacer(modifier = Modifier.height(86.dp))
            Text(text = "Select Your Availability", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp))
            Spacer(modifier = Modifier.height(9.dp))
            DropdownMenu()

            Spacer(modifier = Modifier.height(17.dp))

            Text(text = "Add Your Status", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp))
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                value = status,
                onValueChange = {status = it},
                modifier = Modifier
                    .height(55.dp)
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                singleLine = true, shape = RoundedCornerShape(10.dp),
               //
            )
            Spacer(modifier= Modifier.height(17.dp))
            Text("Select Hyper local Distance", fontSize = 16.sp, fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp))

            Spacer(modifier= Modifier.height(10.dp))
            SliderWithValueDisplay()
            //Spacer(modifier = Modifier.height(10.dp))

            SelectableOptions()
            Spacer(modifier = Modifier.height(1.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Button(onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(Color(0xFF01579B)),) {
                    Text(text = "Save & Explore", fontSize = 14.sp, color = Color.White, )
                }
            }
        }
    }
}

