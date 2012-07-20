organization := "ncurses4j"

name := "ncurses4j"

version := "0.0.3"

libraryDependencies += "net.java.dev.jna" % "jna" % "3.0.9"

publishTo := Some(Resolver.file("GitHub Pages", file("../ncurses4j-gh-pages/maven/")))

// Do not embed Scala version into artifact names.
crossPaths := false
