# Statik

Statik is a simple, type-safe static site generator written in Kotlin. It leverages `kotlinx.html` to provide a DSL for defining web pages and sites.

## Features

- **Type-safe DSL**: Use Kotlin to define your site structure and content.
- **Extensible Themes**: Define your own themes by implementing the `Theme` interface.
- **Simple Site Structure**: Organise your site into `Site` and `Page` objects.

## Quick Start

```kotlin
fun main() {
    val site = Site(
        name = "my-site",
        pages = listOf(
            simplePage(name = "index", title = "Home") {
                h1 { +"Welcome to Statik" }
                p { +"This is a simple static site generated with Kotlin." }
            }
        ),
        data = Unit
    )

    SimpleTheme().renderSite(Path.of("output"), site)
}
```

## Documentation

For more detailed information, please refer to the [Manual](docs/manual.md).
