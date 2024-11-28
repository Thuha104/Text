package com.example.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.AsyncImage
import com.example.components.ui.theme.ComponentsTheme
import kotlinx.coroutines.launch
import java.net.URLDecoder
import java.net.URLEncoder
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                  BottomDemo()

                   //Navigation()
                  //HomeDialogSample()
                  //HomeSnackBarSample()
                  //AnimationVisibility()
                    // AnimationBackgroundColor()
                    //AnimateSizeChange()
                    //AnimateOffset()
                    //SmoothAndColorAnimateText()
                    AnimateBetweenComposableDestinations()

                }

            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomDemo(){
    val bottomSheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }
    val countries = listOf(
        Pair("United States", "\uD83C\uDDFA\uD83C\uDDF8"),
        Pair("Canada", "\uD83C\uDDE8\uD83C\uDDE6"),
        Pair("Germany", "\uD83C\uDDE9\uD83C\uDDEA"),
        Pair("France", "\uD83C\uDDEB\uD83C\uDDF7"),
        Pair("Japan", "\uD83C\uDDEF\uD83C\uDDF5"),
        Pair("China", "\uD83C\uDDE8\uD83C\uDDF3"),
        Pair("Russia", "\uD83C\uDDF7\uD83C\uDDFA"),
        Pair("United Kingdom", "\uD83C\uDDEC\uD83C\uDDE7"),
        Pair("Viet Nam", "\uD83C\uDDFB\uD83C\uDDF3"),
    )
    Scaffold {
        Column(
            modifier = Modifier.padding(it).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { showBottomSheet = true }) {
                Text(text = if (showBottomSheet) "Hide" else "Show")
            }
            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = { showBottomSheet = false },
                    sheetState = bottomSheetState,
                    dragHandle = { BottomSheetDefaults.DragHandle() }) {
                    LazyColumn() {
                        items(countries) { (country, flag) ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp,
                                        horizontal = 20.dp)
                            ) {
                                Text(
                                    text = flag,
                                    modifier = Modifier.padding(end = 20.dp)
                                )
                                Text(text = country)
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(){
    val navdrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope() //xử lý suspending fun (mở và đóng drawer)
    val countries = listOf(
        Pair("United States", "\uD83C\uDDFA\uD83C\uDDF8"),
        Pair("Canada", "\uD83C\uDDE8\uD83C\uDDE6"),
        Pair("Germany", "\uD83C\uDDE9\uD83C\uDDEA"),
        Pair("France", "\uD83C\uDDEB\uD83C\uDDF7"),
        Pair("Japan", "\uD83C\uDDEF\uD83C\uDDF5"),
        Pair("China", "\uD83C\uDDE8\uD83C\uDDF3"),
        Pair("Russia", "\uD83C\uDDF7\uD83C\uDDFA"),
        Pair("United Kingdom", "\uD83C\uDDEC\uD83C\uDDE7"),
        Pair("Viet Nam", "\uD83C\uDDFB\uD83C\uDDF3"),
    )
    ModalNavigationDrawer(
        drawerState = navdrawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text(text = "Danh Sách Các Quốc Gia")
                HorizontalDivider()
                countries.forEach { (country, flag) ->
                    NavigationDrawerItem(
                        label = {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(

                                        vertical = 10.dp,
                                        horizontal = 20.dp
                                    )
                            ) {
                                Text(
                                    text = flag,

                                    modifier = Modifier.padding(end = 20.dp)

                                )

                                Text(text = country)

                            }
                        }, selected = false, onClick = { /*TODO*/ })
                }
            }
        }) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Demo Drawer") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                navdrawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }

                        }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = ""
                            )
                        }
                    }
                )
            }) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Navigation Drawer")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogSample(
    title: String = "",
    content: String = "",
    onDiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDiss,
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(text = "Xác Nhận")
            }
        },
        dismissButton = {
            TextButton(onClick = onDiss) {

                Text(text = "Hủy Thao Tác")
            }
        },
        title = { Text(text = title) },
        text = { Text(text = content) }
    )
}
//Hiện thực thông tin Card chứa Quốc Gia
@Composable
fun CardInfo(
    countryEntry: Pair<String, String>,
    onXoa: () -> Unit,
    onHuyXoa: () -> Unit
) {
    var openDialog by remember { mutableStateOf(false) }
    Card(onClick = { /*TODO*/ }) {
        Row(
            modifier = Modifier.fillMaxSize().padding(start = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.weight(0.8f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = countryEntry.second,
                    modifier = Modifier.padding(end = 20.dp)
                )
                Text(text = countryEntry.first)
            }
            TextButton(
                onClick = {
                    openDialog = true
                }) {
                Text(text = "Xóa")
            }
        }
    }
    if (openDialog) {
        DialogSample(
            onDiss = {
                openDialog = false
                onHuyXoa()
            },
            onConfirm = {
                openDialog = false
                onXoa()
            },
            title = "Xóa Danh Mục Quốc Gia",
            content = "Bạn xóa danh mục quốc gia ${countryEntry.first} không?"
        )
    }
}

//Màn hình chính chứa danh sách
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeDialogSample(modifier: Modifier = Modifier) {
    var thaoTac by remember { mutableStateOf("") }
    val countries = listOf(
        Pair("United States", "\uD83C\uDDFA\uD83C\uDDF8"),
        Pair("Canada", "\uD83C\uDDE8\uD83C\uDDE6"),
        Pair("Germany", "\uD83C\uDDE9\uD83C\uDDEA"),
        Pair("France", "\uD83C\uDDEB\uD83C\uDDF7"),
        Pair("Japan", "\uD83C\uDDEF\uD83C\uDDF5"),
        Pair("China", "\uD83C\uDDE8\uD83C\uDDF3"),
        Pair("Russia", "\uD83C\uDDF7\uD83C\uDDFA"),
        Pair("United Kingdom", "\uD83C\uDDEC\uD83C\uDDE7"),
        Pair("Viet Nam", "\uD83C\uDDFB\uD83C\uDDF3"),
    )
    Scaffold() {
        Column(
            modifier = modifier.padding(it).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(countries) { (country, flag) ->
                    CardInfo(countryEntry = Pair(country, flag),
                        onXoa = { thaoTac = "Bạn đã xác nhận xóa $country" },
                        onHuyXoa = { thaoTac = "" })
                }
            }
            Text(text = thaoTac)
        }
    }
}

@Composable
fun HomeSnackBarSample() {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) {
        Column(
            modifier = Modifier.padding(it).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Button(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        message = "Bạn đã thấy Snackbar",
                        actionLabel = "Thông Báo"

                    )
                }
            }) {
                Text(text = "Show Snackbar")
            }
        }
    }
}

@Composable
fun AnimationVisibility(){
    Box(modifier = Modifier.fillMaxSize()) {
        var visible by remember {
            mutableStateOf(true)
        }
        AnimatedVisibility(visible) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Green)
            ) {
            }
        }
        Button(modifier = Modifier.align(Alignment.BottomCenter), onClick = {
            visible = !visible
        }) {
            Text("Show/Hide")
        }
    }
}

@Composable
fun AnimationBackgroundColor() {
    var onlyOneChange by remember {
        mutableStateOf(true)
    }
    val infiniteTransition = rememberInfiniteTransition(label = "infinite")
    var animateBackgroundColor by remember {
        mutableStateOf(true)
    }
    val colorOneChange by animateColorAsState(
        if (animateBackgroundColor) Color.Green else Color.Blue,
        label = "color"
    )
    val colorInfinite by infiniteTransition.animateColor(
        initialValue = Color.Green,
        targetValue = Color.Blue,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "color"
    )
    Column(
        modifier = Modifier
            .drawBehind {
                drawRect(if (onlyOneChange) colorOneChange else colorInfinite)
            }
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { onlyOneChange = !onlyOneChange }) {
            Text(
                text = if (onlyOneChange) "Chuyển sang thay đổi lặp?"
                else "Chuyển sang thay đổi 1 lần?"
            )
        }
        Text(
            text = "Hiệu ứng đang thay đổi ${
                if (onlyOneChange) " 1 lần"
                else "lặp"
            }"
        )
        if (onlyOneChange) {
            Button(onClick = { animateBackgroundColor = true }) {
                Text(text = "Green")
            }
            Button(onClick = { animateBackgroundColor = false }) {
                Text(text = "Blue")
            }
        }
    }
}

@Composable
fun AnimateSizeChange() {
    val interaction = remember { MutableInteractionSource() }
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .animateContentSize()

                        .height(if (expanded) 400.dp else 200.dp)
                        .fillMaxWidth()
                        .clickable(
                            interactionSource = interaction,

                            indication = null

                        ) {
                            expanded = !expanded
                        }
        ) {
        }
    }
}

@Composable
fun AnimateOffset() {
    val interaction = remember { MutableInteractionSource() }
    var moved by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val pxToMove = with(LocalDensity.current) {
            100.dp.toPx().roundToInt()
        }
        val offset by animateIntOffsetAsState(
            targetValue = if (moved) {
                IntOffset(pxToMove, pxToMove)
            } else {
                IntOffset.Zero
            },
            label = "offset"
        )
        Box(
            modifier = Modifier
                .offset {
                    offset
                }
                .background(Color.Blue)
                .size(100.dp)
                .clickable(
                    interactionSource = interaction,

                    indication = null

                ) {
                    moved = !moved
                }
        )
    }
}

@Composable
fun SmoothAndColorAnimateText() {
    val infiniteTransition = rememberInfiniteTransition(
        label = "infinite transition"
    )
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 8f,
        animationSpec = infiniteRepeatable(
            tween(1000),
            RepeatMode.Reverse
        ),
        label = "scale"
    )
    val animatedColor by infiniteTransition.animateColor(
        initialValue = Color(0xFF60DDAD),
        targetValue = Color(0xFF4285F4),
        animationSpec = infiniteRepeatable(
            tween(1000),
            RepeatMode.Reverse
        ),
        label = "color"
    )
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Hello",
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    transformOrigin = TransformOrigin.Center

                }
                .align(Alignment.Center),
            style = LocalTextStyle.current.copy(
                textMotion = TextMotion.Animated
            ),
            color = animatedColor
        )
    }
}

@Composable
fun AnimateBetweenComposableDestinations() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = "landing",
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        composable("landing") {
            ScreenLanding(
                onItemClicked = {
                    navController.navigate("detail/${URLEncoder.encode(it)}")
                }
            )
        }
        composable(
            "detail/{photoUrl}",
            arguments = listOf(navArgument("photoUrl") { type =
                NavType.StringType }),
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + slideIntoContainer(
                    animationSpec = tween(300, easing = EaseIn),
                    towards =
                    AnimatedContentTransitionScope.SlideDirection.Start
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + slideOutOfContainer(
                    animationSpec = tween(300, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            }
        ) { backStackEntry ->
            ScreenDetails(
                photo =
                URLDecoder.decode(backStackEntry.arguments!!.getString("photoUrl")!!),
                onBackClicked = {
                    navController.popBackStack()
                }
            )
        }
    }
}
@Composable
private fun ScreenLanding(onItemClicked: (String) -> Unit) {
    val randomSizedPhotos = listOf(
        randomSampleImageUrl(width = 1600, height = 900),
        randomSampleImageUrl(width = 900, height = 1600),
        randomSampleImageUrl(width = 500, height = 500),

                randomSampleImageUrl(width = 300, height = 400),
    randomSampleImageUrl(width = 1600, height = 900),
    randomSampleImageUrl(width = 500, height = 500),
    randomSampleImageUrl(width = 1600, height = 900),
    randomSampleImageUrl(width = 900, height = 1600),
    randomSampleImageUrl(width = 500, height = 500),
    )
    LazyVerticalGrid(
        columns = GridCells.Adaptive(200.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        content = {
            items(randomSizedPhotos) { photo ->
                AsyncImage(
                    model = photo,

                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clickable {
                            onItemClicked(photo)
                        }
                )
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ScreenDetails(photo: String, onBackClicked: () -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Photo Details")
                },
                navigationIcon = {
                    IconButton(onClick = { onBackClicked() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription =
                        "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            AsyncImage(
                model = photo,
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)

            )

            Spacer(modifier = Modifier.height(18.dp))
            Text("Photo ", fontSize = 20.sp, modifier =
            Modifier.padding(8.dp))
        }
    }
}
private val rangeForRandom = (0..100000)
fun randomSampleImageUrl(
    seed: Int = rangeForRandom.random(),
    width: Int = 300,
    height: Int = width,
): String {
    return "https://picsum.photos/seed/$seed/$width/$height"
}