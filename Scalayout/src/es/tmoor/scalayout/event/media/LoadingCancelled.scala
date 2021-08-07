package es.tmoor.scalayout
package event
package media

import org.scalajs.dom.raw.UIEvent

abstract trait LoadingCancelled extends ElementEvent {
  def loadingCancelled(e: UIEvent): Unit
  addListener("abort", loadingCancelled(_))
}
