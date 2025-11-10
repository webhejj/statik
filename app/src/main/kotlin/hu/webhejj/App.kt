package hu.webhejj

import hu.webhejj.statik.Site
import hu.webhejj.statik.simple.SimpleTheme
import hu.webhejj.statik.simple.simplePage
import kotlinx.html.h1
import java.nio.file.Path

fun main(args: Array<String>) {
    val site =
        Site(
            "hello",
            listOf(
                simplePage(
                    name = "index",
                    title = "Hello world",
                ) {
                    h1 { +"Hello" }
                },
            ),
            data = Unit,
        )

    SimpleTheme().renderSite(Path.of("build/testsite"), site)
}
