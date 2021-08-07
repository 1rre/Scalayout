package es.tmoor.scalayout
package event
package media

import org.scalajs.dom.raw.Event

abstract trait MediaReady extends ElementEvent {
  def mediaReady(e: Event): Unit
  addListener("canplay", mediaReady(_))
}
