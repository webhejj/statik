package hu.webhejj.statik

import java.nio.file.Path

interface Theme<S, P> {
    fun renderSite(
        rootPath: Path,
        site: Site<S, P>,
    ) {
        site.pages.forEach { page ->
            renderPage(rootPath, site, page)
        }
    }

    fun renderPage(
        rootPath: Path,
        site: Site<S, P>,
        page: Page<P>,
    ) {
        renderPage(PageRenderContext(rootPath, site, page))
    }

    fun renderPage(context: PageRenderContext<S, P>)
}

data class PageRenderContext<S, P>(
    val rootPath: Path,
    val site: Site<S, P>,
    val page: Page<P>,
)
