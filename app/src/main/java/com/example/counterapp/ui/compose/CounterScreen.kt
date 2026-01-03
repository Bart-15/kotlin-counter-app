package com.example.counterapp.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            fontSize = 32.sp,
        )

        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = count.toString(),
            fontSize = 48.sp,
            modifier = Modifier.padding(bottom = 12.dp)

        )

        Row(
            modifier = Modifier.padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            Button(
                onClick = { viewModel.increment() }
            ) {
                Text(text = stringResource(R.string.increment))
            }

            Button(onClick = { viewModel.decrement() }) {
                Text(text = stringResource(R.string.decrement))
            }
        }

        Button(onClick = { viewModel.reset() }) {
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