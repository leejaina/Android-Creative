package adddeletegrid

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AddDeleteGridNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "new_add_delete") {
        composable("new_add_delete") {
            NewAddDeleteScreen(onMoveClick = {
                navController.navigate("add_delete_grid")
            })
        }
        composable("add_delete_grid") {
            AddDeleteGridScreen(onMoveClick = {
                navController.popBackStack() // 이전 화면(NewAddDeleteScreen)으로 이동
            })
        }
    }
}

