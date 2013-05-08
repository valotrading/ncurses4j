organization := "ncurses4j"

name := "ncurses4j"

version := "0.1.0"

libraryDependencies += "net.java.dev.jna" % "jna" % "3.2.4"

publishTo := Some(Resolver.file("GitHub Pages", file("../maven-gh-pages/")))

// Do not embed Scala version into artifact names.
crossPaths := false
