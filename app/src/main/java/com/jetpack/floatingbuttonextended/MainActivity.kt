package com.jetpack.floatingbuttonextended

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpack.floatingbuttonextended.ui.theme.FloatingButtonExtendedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FloatingButtonExtendedTheme {
                Surface(color = MaterialTheme.colors.background) {
                    FloatingButtonExtended()
                }
            }
        }
    }
}

@Composable
fun FloatingButtonExtended() {
    val menuExpanded = remember { mutableStateOf(false) }

    val topBar: @Composable ()-> Unit = {
        TopAppBar(
            title = {
                Text(
                    text = "Floating Button Extended",
                    color = Color.White,
                    fontSize = 20.sp
                )
            },
            navigationIcon = {
                IconButton(onClick = {  }) {
                    Icon(Icons.Filled.Menu, contentDescription = "")
                }
            },
            actions = {
                IconButton(
                    onClick = {
                        menuExpanded.value = true
                    }
                ) {
                    Icon(
                        Icons.Filled.MoreVert,
                        contentDescription = "Menu",
                        tint = Color.White
                    )
                }

                Column(
                    modifier = Modifier
                ) {
                    DropdownMenu(
                        expanded = menuExpanded.value,
                        onDismissRequest = {
                            menuExpanded.value = false
                        },
                        modifier = Modifier.width(200.dp)
                    ) {
                        DropdownMenuItem(onClick = {  }) {
                            Text(text = "Sample 1")
                        }
                        DropdownMenuItem(onClick = {  }) {
                            Text(text = "Sample 2")
                        }
                        DropdownMenuItem(onClick = {  }) {
                            Text(text = "Sample 3")
                        }
                        DropdownMenuItem(onClick = {  }) {
                            Text(text = "Sample 4")
                        }
                        DropdownMenuItem(onClick = {  }) {
                            Text(text = "Sample 5")
                        }
                    }
                }
            },
            backgroundColor = MaterialTheme.colors.primary,
            elevation = AppBarDefaults.TopAppBarElevation
        )
    }

    Scaffold(
        topBar = {
            topBar()
        },
        content = { },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = {
                    Text(text = "Add")
                },
                onClick = {

                },
                icon = {  Icon(Icons.Filled.Add, "") },
                elevation = FloatingActionButtonDefaults.elevation()
            )
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            BottomAppBar(
                cutoutShape = RoundedCornerShape(50),
                content = {
                    BottomNavigation {
                        BottomNavigationItem(
                            selected = false,
                            onClick = {

                            },
                            icon = {
                                Icon(Icons.Filled.Home, "")
                            },
                            label = { Text(text = "Home") },
                            alwaysShowLabel = false
                        )

                        BottomNavigationItem(
                            selected = false,
                            onClick = {

                            },
                            icon = {
                                Icon(Icons.Filled.Settings, "")
                            },
                            label = { Text(text = "Settings") },
                            alwaysShowLabel = false
                        )
                    }
                }
            )
        }
    )
}























