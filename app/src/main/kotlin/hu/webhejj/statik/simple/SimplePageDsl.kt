package hu.webhejj.statik.simple

import hu.webhejj.statik.Page
import kotlinx.html.BODY
import kotlinx.html.FlowOrMetaDataOrPhrasingContent

fun simplePage(
    name: String,
    title: String,
    path: String? = null,
    headerBlock: FlowOrMetaDataOrPhrasingContent.() -> Unit = {},
    bodyBlock: BODY.() -> Unit,
): Page<SimplePageData> {
    return Page(
        name = name,
        path = path,
        SimplePageData(title, headerBlock, bodyBlock),
    )
}
