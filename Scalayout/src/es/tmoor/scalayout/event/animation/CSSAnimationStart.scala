package es.tmoor.scalayout
package event
package animation

import org.scalajs.dom.raw.AnimationEvent

abstract trait CSSAnimationStart extends ElementEvent {
  def cssAnimationStart(e: AnimationEvent): Unit
  addListener("animationstart", cssAnimationStart(_))
}
