organization := "ncurses4j"

name := "ncurses4j"

version := "0.0.6-SNAPSHOT"

libraryDependencies += "net.java.dev.jna" % "jna" % "3.2.4"

publishTo := Some(Resolver.file("GitHub Pages", file("../ncurses4j-gh-pages/maven/")))

// Do not embed Scala version into artifact names.
crossPaths := false
