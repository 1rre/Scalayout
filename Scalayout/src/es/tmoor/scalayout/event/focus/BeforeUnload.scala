package es.tmoor.scalayout
package event
package focus

import org.scalajs.dom.raw.UIEvent
import org.scalajs.dom.html

abstract trait BeforePageUnload extends ElementEvent {
  def beforePageUnload(e: UIEvent): Unit
  addListener("beforeunload", beforePageUnload(_))
}
