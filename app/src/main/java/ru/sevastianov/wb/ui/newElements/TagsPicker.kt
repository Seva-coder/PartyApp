package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.ui.models.TagUI


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TagsPicker(
    tagsList: List<TagUI>,
    enabledTags: Set<Long>,
    updateTags: (Set<Long>) -> Unit,
    size: TagSize
) {
    var enabled by remember { mutableStateOf(enabledTags) }

    FlowRow {
        tagsList.forEach { tag ->
            Box(modifier = Modifier.padding(8.dp)) {
                Tag(name = tag.name, size = size, selected = enabled.contains(tag.id), onClick = {
                    enabled = if (enabled.contains(tag.id)) {
                        enabled.minus(tag.id)
                    } else {
                        enabled.plus(tag.id)
                    }
                    updateTags(enabled)
                })
            }
        }
    }

}