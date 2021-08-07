package es.tmoor.scalayout
package template

abstract class FixedAspectRatio extends Template {
  def aspectRatio: Double
  def alignmentInParent: (Double, Double)
  def alignmentOffset: (Double, Double)

  override def globalPosition = {
    val calculatedWidth = sizeRelativeTo._2 * aspectRatio
    val calculatedHeight = sizeRelativeTo._1 / aspectRatio
    if (calculatedWidth > sizeRelativeTo._1) {
      val paddingHeight = sizeRelativeTo._1 - calculatedHeight
      println(s"Calculated height: $calculatedHeight")
      println(s"Padding height: $paddingHeight")
      val x = positionInParent.x * sizeRelativeTo._1
      val y = paddingHeight * alignmentInParent._2 + positionInParent.y * calculatedHeight
      val w = positionInParent.w * sizeRelativeTo._1
      val h = positionInParent.h * calculatedHeight
      println(s"Modified y, h")
      println(x,y,w,h)
      (x,y,w,h)
    } else {
      val paddingWidth = sizeRelativeTo._1 - calculatedWidth
      println(s"Calculated width: $calculatedWidth")
      println(s"Padding width: $paddingWidth")
      val x = paddingWidth * alignmentInParent._1 + positionInParent.x * calculatedWidth
      val y = positionInParent.y * sizeRelativeTo._2
      val w = positionInParent.w * calculatedWidth
      val h = positionInParent.h * sizeRelativeTo._2
      println(s"Modified x, w")
      println(x,y,w,h)
      (x,y,w,h)
    }
  }

}