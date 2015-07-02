name := "palindromes"

version := "1.0"

scalaVersion := "2.11.7"

// Testing libraries
libraryDependencies ++= Seq(
  "org.mockito" % "mockito-all" % "1.9.5" % Test,
  "org.specs2" % "specs2-mock_2.11" % "3.6.2" % Test,
  "org.specs2" %% "specs2-core" % "3.6.2" % Test
)
