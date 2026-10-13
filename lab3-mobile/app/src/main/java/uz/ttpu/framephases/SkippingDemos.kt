package uz.ttpu.framephases

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun ParentValueDemo() {
    var count by remember { mutableIntStateOf(0) }
    SideEffect { Log.d("Skip", "Parent: composition") }

    Column (
        Modifier.fillMaxSize().statusBarsPadding()
    ){
        Button(onClick = { count++ }) { Text("Add") }
        ChildValue(count)
        Sibling()

    }
}

@Composable
fun ChildValue(count: Int) {
    SideEffect { Log.d("Skip", "Child: composition") }
    Text("Count: $count")
}

@Composable
fun ParentLambdaDemo() {
    var count by remember { mutableIntStateOf(0) }
    SideEffect { Log.d("Skip", "Parent: composition") }

    Column (Modifier.fillMaxSize().statusBarsPadding()){
        Button(onClick = { count++ }) { Text("Add") }
        ChildLambda(count = { count })
        Sibling()
    }
}

@Composable
fun ChildLambda(count: () -> Int) {
    SideEffect { Log.d("Skip", "Child: composition") }
    Text("Count: ${count()}")
}

@Composable
fun Sibling() {
    SideEffect { Log.d("Skip", "Sibling: composition") }
    Text("I never change")
}