# Statik Manual

Statik is a Kotlin library for generating static websites. This manual provides a guide on how to use its core components and features.

## Core Concepts

### Site

A `Site` represents the entire website. It consists of a name, a list of pages, and optional global data.

```kotlin
class Site<S, P>(
    val name: String,
    val pages: List<Page<P>>,
    val data: S
)
```

### Page

A `Page` represents a single web page within the site. It has a name (used as the filename), an optional path (relative to the site root), and page-specific data.

```kotlin
class Page<P>(
    val name: String,
    val path: String? = null,
    val data: P
)
```

### Theme

A `Theme` is responsible for rendering the `Site` and its `Pages` into actual files. It defines how the data in the `Site` and `Page` objects is transformed into HTML.

```kotlin
interface Theme<S, P> {
    fun renderSite(rootPath: Path, site: Site<S, P>)
    fun renderPage(context: PageRenderContext<S, P>)
}
```

## Simple Theme

Statik includes a `SimpleTheme` that provides a basic implementation for creating HTML pages using `kotlinx.html`.

### Using `simplePage`

The `simplePage` DSL function makes it easy to create pages for the `SimpleTheme`.

```kotlin
simplePage(
    name = "index",
    title = "My Page Title"
) {
    h1 { +"Heading" }
    p { +"Content goes here." }
}
```

## Custom Themes

To create a custom theme, implement the `Theme` interface and define your own `renderPage` logic. You can use any HTML generation library or even template engines.

## Example Project Structure

```text
statik/
├── app/
│   └── src/main/kotlin/
│       └── hu/webhejj/
│           ├── App.kt          # Entry point
│           └── statik/         # Core library
└── docs/
    └── manual.md               # This manual
```
