package es.tmoor.scalayout
package event
package print

import org.scalajs.dom.raw.Event

abstract trait AfterPrint extends ElementEvent {
  def afterPrint(e: Event): Unit
  addListener("afterprint", afterPrint(_))
}
