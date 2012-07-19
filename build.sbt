organization := "ncurses4j"

name := "ncurses4j"

version := "0.0.1-SNAPSHOT"

libraryDependencies += "net.java.dev.jna" % "jna" % "3.0.9"

publishTo := Some(Resolver.file("GitHub Pages", file("../ncurses4j-gh-pages/maven/")))
