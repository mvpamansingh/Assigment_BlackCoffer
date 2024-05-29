@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.assignment.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.DrawerValue
import androidx.compose.material.ModalDrawer
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.assignment.SearchBar
import kotlinx.coroutines.launch
import com.example.assignment.R
import com.example.assignment.RefineScreen

@Composable
fun CardElement()
{

    Box (modifier =
    Modifier.fillMaxWidth()){

        Card(
            modifier = Modifier
                .padding(start = 40.dp, end = 16.dp, top = 16.dp)
                .border(1.dp, Color(0xFFB4DDFC), RoundedCornerShape(16.dp))
        ,)
        {

            Column(modifier= Modifier.padding(start = 78.dp)) {
                Spacer(modifier = Modifier
                    .height(10.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()
                    ,horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Aman Singh"
                        ,fontSize = 18.sp
                        ,fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.Default)
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(text = "Invite",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
                Text(text = "Pune | UI & UX Designer"
                , fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Within 9 KM", fontWeight = FontWeight.Normal, style= TextStyle(Color.Gray) )
                ProfileScore(progress = 0.18f)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Column(modifier = Modifier.padding(start = 16.dp)) {


                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 12.dp)) {
                    Icon(imageVector = Icons.Default.Coffee, contentDescription = null)
                    Text(text = " Coffee |  ", fontSize = 14.sp)
                    Icon(imageVector = Icons.Default.Badge, contentDescription = null)
                    Text(text = " Business |  ", fontSize = 14.sp)
                    Icon(imageVector = Icons.Default.People, contentDescription = null)
                    Text(text = " Friendship", fontSize = 14.sp)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Hi Community! I am open to new connections\n \uD83D\uDE00 ", fontWeight = FontWeight.Medium)
                Text(text = "Skilled Ui designer and Graphic Designer \nwith 1 year of  experience as  Freelancer \nproven ability to create visually appealing . . ."
                , fontWeight = FontWeight.Normal, fontSize = 14.sp, )

                Spacer(modifier = Modifier.height(16.dp))

            }

        }

        Box(modifier = Modifier
            .padding(start = 16.dp, top = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .height(90.dp)
            .width(90.dp)
            .background(Color(0xFF2997EB)))
        {
            //Text(text = "Aman Singh")
            Image(painter = painterResource(id = R.drawable.sampleimage), contentDescription ="" ,modifier= Modifier.fillMaxSize())
        }
    }
}

@Composable
fun ProfileScore(progress: Float) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = 2.dp, end = 16.dp, top= 4.dp)
    ) {
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier
                .height(8.dp)
                .width(100.dp)
                .clip(RoundedCornerShape(4.dp)),
            color = Color(0xFF607D8B),
            trackColor = Color(0xFFCFD8DC)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Profile Score - ${(progress * 100).toInt()}%",
            fontSize = 14.sp,
            color = Color(0xFF607D8B)
        )
    }
}



@Composable
fun ExploreScreen() {
    val scaffoldStatee = rememberScaffoldState()
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val tabs = listOf("Personal", "Services", "Businesses")
    var selectedTabIndex by remember { mutableStateOf(0) }
    val scope = rememberCoroutineScope()

    val bottomNavItems = listOf(
        BottomNavItem("personal", Icons.Default.Visibility, "Explore"),
        BottomNavItem("services", Icons.Default.Link, "Connections"),
        BottomNavItem("chat", Icons.Default.Chat, "Chat"),
        BottomNavItem("contacts", Icons.Default.Contacts, "Contacts"),
        BottomNavItem("groups", Icons.Default.Group, "Groups")
    )

    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Menu Item 1", modifier = Modifier.padding(8.dp))
                Text(text = "Menu Item 2", modifier = Modifier.padding(8.dp))
            }
        }
    ) {
        Scaffold(

            topBar = {
                TopAppBar(
                    title = {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(text = "Howdy Nirmal S !!", color = Color.White)
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(imageVector = Icons.Default.LocationOn, contentDescription = null, tint = Color.White)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(text = "Bhilai Marshalling Yard, Bhilai", fontSize = 12.sp, color = Color.White)
                            }
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
                        }
                    },
                    actions = {
                        IconButton(onClick = { navController.navigate("refinescreen") }) {
                            Icon(imageVector = Icons.Default.Checklist, contentDescription = "Refine", tint = Color.White, modifier = Modifier.fillMaxSize())
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(Color(0xFF044579))
                )
            },
            bottomBar = {
                BottomNavigationBar(navController = navController, items = bottomNavItems)
            },
            content = { padding ->
                Column(modifier = Modifier.padding(padding)) {
                    ScrollableTabRow(
                        selectedTabIndex = selectedTabIndex,
                        edgePadding = 0.dp,
                        backgroundColor = Color(0xFF01579B),
                        contentColor = Color.White
                    ) {
                        tabs.forEachIndexed { index, title ->
                            Tab(
                                selected = selectedTabIndex == index,
                                onClick = { selectedTabIndex = index },
                                text = { Text(text = "$title             ", color = Color.White) }
                            )
                        }
                    }
                    NavHost(
                        navController = navController,
                        startDestination = "personal"
                    ) {
                        composable("personal") { PersonalScreen() }
                        composable("services") { ServicesScreen() }
                        composable("businesses") { BusinessesScreen() }
                        // Add destinations for the bottom navigation items
                        composable("chat") { ChatScreen() }
                        composable("contacts") { ContactsScreen() }
                        composable("groups") { GroupsScreen() }
                        composable("refinescreen"){ RefineScreen()}
                    }
                }
            }
        )
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController, items: List<BottomNavItem>) {
    BottomNavigation(backgroundColor = Color.White) {
        val currentRoute = currentRoute(navController)
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

data class BottomNavItem(val route: String, val icon: ImageVector, val label: String)

@Composable
fun PersonalScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        val cardItems = listOf("Aman Singh", "Rupak Sahu", "Krishna Soni") // Example data


        Column(
            modifier= Modifier.fillMaxSize()
        ) {
            SearchBar()


            //Spacer(modifier = Modifier.height(10.dp))


            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                contentPadding = PaddingValues(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                repeat(5)
                {
                    item {
                        CardElement()
                    }
                }
            }

        }

    }
}

@Composable
fun ServicesScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Services Screen")
    }
}

@Composable
fun BusinessesScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Businesses Screen")
    }
}

@Composable
fun ChatScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Chat Screen")
    }
}

@Composable
fun ContactsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Contacts Screen")
    }
}

@Composable
fun GroupsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Groups Screen")
    }
}