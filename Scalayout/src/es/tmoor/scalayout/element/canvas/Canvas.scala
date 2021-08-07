package es.tmoor.scalayout
package element.canvas

import org.scalajs.dom.{html, raw, document, window}
import org.scalajs.dom.raw.CanvasRenderingContext2D
import template.FixedAspectRatio

abstract class Canvas(parent: Node, lightModeBackground: String = "#ffffff", darkModeBackground: String = "#000000") extends Element(parent) with CanvasTemplate {
  def elementType = "canvas"
  def parent: CanvasTemplate = this
  def canvas = web.asInstanceOf[html.Canvas]
  canvas.setAttribute("tabindex", "0")
  canvas.height = canvas.clientHeight
  canvas.width = canvas.clientWidth

  window.addEventListener("resize", (e: raw.Event) => {
    canvas.height = canvas.clientHeight
    canvas.width = canvas.clientWidth
    render()
  }) 

  def rotation = 0

  canvas.onmousemove = (e) => render()

  def relativeOffset = (0,0)
  def relativeSize = (1,1)

  override val context: Context = new Context(canvas.getContext("2d").asInstanceOf[CanvasRenderingContext2D])
  
  canvas.style.background = lightModeBackground
  
  def render(): Unit = {
    canvasChildren.foreach(_.do_render())
  }
  
  override protected def renderAll(): Unit = {
    do_render()
  }

}
