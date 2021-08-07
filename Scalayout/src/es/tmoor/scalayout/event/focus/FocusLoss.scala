package es.tmoor.scalayout
package event
package focus

import org.scalajs.dom.raw.FocusEvent
import org.scalajs.dom.html

abstract trait FocusLoss extends ElementEvent {
  def focusLoss(e: FocusEvent): Unit
  addListener("blur", focusLoss(_))
}
