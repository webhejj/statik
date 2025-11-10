package hu.webhejj.statik.html

import kotlinx.html.FlowContent
import kotlinx.html.table
import kotlinx.html.td
import kotlinx.html.th
import kotlinx.html.tr

fun FlowContent.dataTable(
    data: List<List<String>>,
    headers: List<String>? = null,
) {
    val actualHeaders = headers ?: data.firstOrNull() ?: emptyList()
    val actualData = if (headers == null) data.drop(1) else data
    table {
        tr {
            actualHeaders.forEach { header ->
                th { +header }
            }
        }
        actualData.forEach { row ->
            tr {
                row.forEach { cell ->
                    td { +cell }
                }
            }
        }
    }
}
