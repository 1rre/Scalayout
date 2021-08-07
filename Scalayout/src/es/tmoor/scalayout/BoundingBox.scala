package es.tmoor.scalayout



object BoundingBox {
  import scala.language.implicitConversions
  implicit def `iddd=>bb`(bb: (Int, Double, Double, Double)): BoundingBox = BoundingBox(bb._1, bb._2, bb._3, bb._4)
  implicit def `iidd=>bb`(bb: (Int, Int, Double, Double)): BoundingBox = BoundingBox(bb._1, bb._2, bb._3, bb._4)
  implicit def `iiid=>bb`(bb: (Int, Int, Int, Double)): BoundingBox = BoundingBox(bb._1, bb._2, bb._3, bb._4)
  implicit def `iiii=>bb`(bb: (Int, Int, Int, Int)): BoundingBox = BoundingBox(bb._1, bb._2, bb._3, bb._4)
  implicit def `iidi=>bb`(bb: (Int, Int, Double, Int)): BoundingBox = BoundingBox(bb._1, bb._2, bb._3, bb._4)
  implicit def `idid=>bb`(bb: (Int, Double, Int, Double)): BoundingBox = BoundingBox(bb._1, bb._2, bb._3, bb._4)
  implicit def `idii=>bb`(bb: (Int, Double, Int, Int)): BoundingBox = BoundingBox(bb._1, bb._2, bb._3, bb._4)
  implicit def `dddd=>bb`(bb: (Double, Double, Double, Double)): BoundingBox = BoundingBox(bb._1, bb._2, bb._3, bb._4)
  implicit def `didd=>bb`(bb: (Double, Int, Double, Double)): BoundingBox = BoundingBox(bb._1, bb._2, bb._3, bb._4)
  implicit def `diid=>bb`(bb: (Double, Int, Int, Double)): BoundingBox = BoundingBox(bb._1, bb._2, bb._3, bb._4)
  implicit def `diii=>bb`(bb: (Double, Int, Int, Int)): BoundingBox = BoundingBox(bb._1, bb._2, bb._3, bb._4)
  implicit def `didi=>bb`(bb: (Double, Int, Double, Int)): BoundingBox = BoundingBox(bb._1, bb._2, bb._3, bb._4)
  implicit def `ddid=>bb`(bb: (Double, Double, Int, Double)): BoundingBox = BoundingBox(bb._1, bb._2, bb._3, bb._4)
  implicit def `ddii=>bb`(bb: (Double, Double, Int, Int)): BoundingBox = BoundingBox(bb._1, bb._2, bb._3, bb._4)
}

case class BoundingBox(x: Double, y: Double, w: Double, h: Double) {
  def intersects(px: Double, py: Double): Boolean =
    px >= x && px <= x + w && py >= y && py <= y + w
}