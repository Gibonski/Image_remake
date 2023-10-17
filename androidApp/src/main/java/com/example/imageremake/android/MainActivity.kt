package com.example.applied3.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmployeeHomeScreen()
        }
    }
}

@Preview
@Composable
fun EmployeeHomePreview() {
    EmployeeHomeScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployeeHomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
    ) {
        // Top bar
        TopAppBar(
            title = { Text(text = "Employee Home") },
            navigationIcon = {
                Image(
                    painter = painterResource(id = R.drawable.bugger),
                    contentDescription = "Burger Menu Icon"
                )
            },
            actions = {
                Image(
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = "Notification Icon",
                    modifier = Modifier.padding(end = 16.dp)

                )
            }
        )

        // Employee Details
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Employee Image
            Image(
                painter = painterResource(id = R.drawable.face),
                contentDescription = "Employee Image",
                modifier = Modifier
                    .size(48.dp)
                    .clip(MaterialTheme.shapes.extraLarge)
            )

            // Employee Name and Designation
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = "Jessica Jones",
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = "Purchase Manager - Finance",
                    style = MaterialTheme.typography.bodySmall
                )


                // Add View Personal Profile with expandable icon
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {

                    }
                ) {
                    Text(
                        text = "View Personal Profile",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(end = 4.dp)
                    )

                    Icon(
                        imageVector = Icons.Rounded.KeyboardArrowDown,
                        contentDescription = "Expandable Icon",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }


        // Top bar, employee details, and headings
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {

            // Headings
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "My Dashboard",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(8.dp)

                )
                Text(
                    text = "My Approvals",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(8.dp)

                )
                Text(
                    text = "Others",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(8.dp)

                )
            }


            // Grid of Images and Text Descriptions
            repeat(3) { rowIndex ->
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.LightGray),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    repeat(2) { columnIndex ->
                        val (imageResource, description) = when (rowIndex * 2 + columnIndex) {
                            0 -> R.drawable.clock to "Project Booking"
                            1 -> R.drawable.calender1 to "Time Off"
                            2 -> R.drawable.expence to "Expenses"
                            3 -> R.drawable.travel to "Travel"
                            4 -> R.drawable.calender2 to "Time Off"
                            5 -> R.drawable.clock2 to "Project Booking"
                            else -> R.drawable.placehold to "Placeholder" // Default
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,

                            ) {
                            Image(
                                painter = painterResource(id = imageResource),
                                contentDescription = "Image $rowIndex-$columnIndex",
                                modifier = Modifier
                                    .size(100.dp)
                                    .padding(8.dp)
                            )
                            Text(
                                text = description,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }

        }
    }
}







