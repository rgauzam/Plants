package com.example.plants.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.plants.R
import com.example.plants.model.Plant
import com.example.plants.model.PreviewPlant
import com.example.plants.model.data
import com.example.plants.ui.theme.PlantsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantsApp() {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            PlantsTopAppBar()
        }
    ) {
        Column() {
            val plants = data.PlantsRepository.plants
            PlantsList(plants = plants, Modifier.padding(it))

        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantsTopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        },
    )
}


@Composable
fun PlantsList(
    plants: List<Plant>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(plants) { plant ->
            PlantItem(plant = plant, modifier = Modifier)
        }
    }
}


@Composable
fun PlantItem(
    plant: Plant,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        elevation = CardDefaults.elevatedCardElevation(),
        shape = shapes.medium,
        modifier = Modifier
            .padding(dimensionResource(R.dimen.card_spacer))
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16 / 9f)
                    .clip(MaterialTheme.shapes.medium),

                ) {
                Image(
                    painter = painterResource(plant.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(plant.nameRes),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }

            }
            AnimatedVisibility(visible = expanded) {
                Text(
                    text = stringResource(plant.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview
@Composable
fun PlantPreview() {
    PlantsTheme(darkTheme = false) {
        PlantItem(PreviewPlant)
    }
}
