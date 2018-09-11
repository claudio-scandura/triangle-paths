val settings = {
  name := "triangle-paths"
  version := "1.0"

  scalaVersion := "2.12.6"
}




val dependencies = Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test,it"
)

lazy val root = (project in file("."))
  .configs(IntegrationTest)
  .settings(libraryDependencies ++= dependencies)
  .settings(settings ++ Defaults.itSettings: _*)
