package es.tmoor.scalayout
package event
package animation

import org.scalajs.dom.raw.AnimationEvent

abstract trait CSSAnimationFinish extends ElementEvent {
  def cssAnimationFinish(e: AnimationEvent): Unit
  addListener("animationend", cssAnimationFinish(_))
}
