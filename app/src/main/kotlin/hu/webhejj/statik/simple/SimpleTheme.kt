package hu.webhejj.statik.simple

import hu.webhejj.statik.Page
import hu.webhejj.statik.PageRenderContext
import hu.webhejj.statik.Theme
import kotlinx.html.BODY
import kotlinx.html.FlowOrMetaDataOrPhrasingContent
import kotlinx.html.HEAD
import kotlinx.html.body
import kotlinx.html.head
import kotlinx.html.meta
import kotlinx.html.stream.appendHTML
import kotlinx.html.title
import kotlinx.html.visit
import java.io.BufferedWriter
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.createDirectories

class SimpleTheme : Theme<Unit, SimplePageData> {
    override fun renderPage(context: PageRenderContext<Unit, SimplePageData>) {
        val page = context.page
        fileWriter(context.rootPath, page).use {
            val html = it.appendHTML()
            html.head {
                renderHead(context)
            }
            html.body {
                renderBody(context)
            }
        }
    }

    protected fun fileWriter(
        output: Path,
        page: Page<SimplePageData>,
    ): BufferedWriter {
        val parent = page.path?.let { output.resolve(page.path) } ?: output
        val path = parent.resolve("${page.name}.html")
        parent.createDirectories()
        return Files.newBufferedWriter(path)
    }

    protected fun HEAD.renderHead(context: PageRenderContext<Unit, SimplePageData>) {
        meta {
            name = "viewport"
            content = "width=device-width, initial-scale=1.0"
        }
        title {
            +context.page.data.title
        }
        visit(context.page.data.headerBlock)
    }

    protected fun BODY.renderBody(context: PageRenderContext<Unit, SimplePageData>) {
        visit(context.page.data.bodyBlock)
    }
}

data class SimplePageData(
    val title: String,
    val headerBlock: FlowOrMetaDataOrPhrasingContent.() -> Unit = {},
    val bodyBlock: BODY.() -> Unit,
)
