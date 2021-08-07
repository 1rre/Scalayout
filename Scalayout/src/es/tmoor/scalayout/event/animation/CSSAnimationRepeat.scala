package es.tmoor.scalayout
package event
package animation


import org.scalajs.dom.raw.AnimationEvent
import org.scalajs.dom.html

abstract trait CSSAnimationRepeat extends ElementEvent {
  def cssAnimationRepeat(e: AnimationEvent): Unit
  addListener("animationiteration", cssAnimationRepeat(_))
}
