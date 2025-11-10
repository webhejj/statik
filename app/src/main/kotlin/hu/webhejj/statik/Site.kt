package hu.webhejj.statik

class Site<S, P>(
    val name: String,
    val pages: List<Page<P>>,
    val data: S,
)

class Page<P>(
    val name: String,
    val path: String? = null,
    val data: P,
)
