package com.example.counterapp.ui.compose

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.counterapp.R
import com.example.counterapp.ui.theme.CounterAppTheme
import com.example.counterapp.viewmodel.CounterViewModel


@Composable()
fun CounterScreen(
    viewModel: CounterViewModel = viewModel(),
    modifier: Modifier = Modifier
){
    val count = viewModel.count

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = stringResource(R.string.app_name),
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.height(48.dp))

        AnimatedContent(
            targetState = count,
            transitionSpec = {
                slideInVertically { it } + fadeIn() togetherWith
                        slideOutVertically { -it } + fadeOut()
            },
            label = "CounterAnimation"
        ) {
            value ->
            Text(
                text = value.toString(),
                fontSize = 48.sp,
                modifier = Modifier.padding(bottom = 12.dp)
                    .testTag("countText")
            )
        }


        Row(
            modifier = Modifier.padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            Button(
                onClick = { viewModel.decrement() },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.testTag("decrementButton")
            ) {
                Text(text = stringResource(R.string.decrement))
            }

            Button(
                onClick = { viewModel.increment() },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.testTag("incrementButton")
            ) {
                Text(text = stringResource(R.string.increment))
            }
        }

        OutlinedButton(
            onClick = { viewModel.reset() },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.testTag("resetButton")
        ) {
            Text(text = stringResource(R.string.reset))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CounterScreenPreview() {
    CounterAppTheme {
        CounterScreen()
    }
}