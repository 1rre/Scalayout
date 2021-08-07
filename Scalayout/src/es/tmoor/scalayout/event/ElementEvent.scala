package es.tmoor.scalayout
package event

import org.scalajs.dom.raw.Event

trait ElementEvent {
  protected final def addListener[T <: Event](name: String, e: T => Unit): Unit = {
    println(s"Adding listener for $name: $e")
    this match {
      case elem: Element => elem.web.addEventListener(name, (ev: T) => {
        println(s"Triggering $ev")
        e(ev)
      })
      case _ =>
    }
  }
}