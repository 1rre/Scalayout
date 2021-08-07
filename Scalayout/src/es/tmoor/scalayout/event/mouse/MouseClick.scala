package es.tmoor.scalayout
package event
package mouse

import org.scalajs.dom.raw.MouseEvent

abstract trait MouseClick extends ElementEvent {
  def mouseClick(e: MouseEvent): Unit
  println("Adding Mouseclick event")
  addListener("click", mouseClick(_))
}