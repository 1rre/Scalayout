import es.tmoor.scalayout._
import es.tmoor.scalayout.element.Region
import es.tmoor.scalayout.element.canvas.Canvas
import es.tmoor.scalayout.template.FixedAspectRatio

object TitleBar extends Region(Page.Body) {
  val template: Template = new Template {
    val parent = Page.Body
    def positionInParent: BoundingBox = (0,0,1,0.1)
    def sizeRelativeTo: (Double, Double) = (viewPort.w, viewPort.h)
    def offsetRelativeTo: (Double, Double) = parentOffset
  }

  
  web.style.background = "#707070"
  object Logo extends Canvas(TitleBar) {
    val template: Template = new FixedAspectRatio {
      val parent: Element = TitleBar
      def positionInParent: BoundingBox = (0.1, 0.1, 0.8, 0.8)
      def aspectRatio: Double = 1
      def alignmentInParent: (Double, Double) = (0.5,0.5)
      def alignmentOffset: (Double, Double) = (0,0)
      def sizeRelativeTo: (Double, Double) = parentSize
      def offsetRelativeTo: (Double, Double) = parentOffset
    }
  }

  Logo.load()
}