import sbt._

object Test {
  def apply() = Seq(
    "org.scalatest" %% "scalatest" % "3.0.1" % "test",
    "org.scala-lang.modules" %% "scala-xml" % "1.0.6" % "test",
    "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4" % "test"
  )
}

object App {
  def apply() = Seq(
  )
}

object IntTest {
  def apply() = Seq(
    "org.scalatest" %% "scalatest" % "3.0.1" % "it",
    "org.scala-lang.modules" %% "scala-xml" % "1.0.6" % "it",
    "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4" % "it"
  )
}
