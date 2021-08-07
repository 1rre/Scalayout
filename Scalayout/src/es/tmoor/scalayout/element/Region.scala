package es.tmoor.scalayout
package element

import org.scalajs.dom.{html, raw, window, document}

abstract class Region(parent: Node) extends Element(parent) {
  def elementType: String = "div"
  val template: Template
}
