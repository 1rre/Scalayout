import mill._, scalalib._, scalajslib._

object Scalayout extends ScalaJSModule {
  def scalaVersion = "2.13.6"
  def scalaJSVersion = "1.6.0"
  def scalacOptions = Seq("-deprecation")
  def ivyDeps = Agg(ivy"org.scala-js:scalajs-dom_sjs1_2.13:1.1.0")
}

object CV extends ScalaJSModule {
  def scalaVersion = "2.13.6"
  def scalaJSVersion = "1.6.0"
  def scalacOptions = Seq("-deprecation")
  def moduleDeps = Seq(Scalayout)
}