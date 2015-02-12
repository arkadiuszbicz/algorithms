lazy val root = (project in file(".")).
  settings(
    name := "algorithms",
    version := "0.1",
    scalaVersion := "2.11.4",
    libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.12.2"
  )
