package es.tmoor.scalayout

import org.scalajs.dom.{html, raw, window, document}
import collection.mutable.Buffer
import event.animation._

abstract class Node {
  val web: html.Element
  final def viewPort: BoundingBox = (0, 0, window.innerWidth, window.innerHeight)
  def load(): Unit = {}
  protected val children = Buffer[Element]()
  def addChild(child: Element) = {
    web.appendChild(child.web)
    children += child
  }
  val template: Template
  def globalPosition = template.globalPosition
  protected def setSize(): Unit = {
    web.style.left = s"${globalPosition.x}px"
    web.style.top = s"${globalPosition.y}px"
    web.style.width = s"${globalPosition.w}px"
    web.style.height = s"${globalPosition.h}px"
    children.foreach(_.setSize())
  }
}

abstract class Element(parent: Node) extends Node {
  def parentOffset = (parent.globalPosition.x, parent.globalPosition.y)
  def parentSize = (parent.globalPosition.w, parent.globalPosition.h)
  def elementType: String
  val web = document.createElement(elementType).asInstanceOf[html.Element]
  parent.addChild(this)
  web.style.position = "absolute"
}

abstract trait Template {
  def offsetRelativeTo: (Double, Double)
  def sizeRelativeTo: (Double, Double)
  def positionInParent: BoundingBox
  def globalPosition: BoundingBox = {
    val x = offsetRelativeTo._1 + positionInParent.x * sizeRelativeTo._1
    val y = offsetRelativeTo._1 + positionInParent.y * sizeRelativeTo._2
    val w = positionInParent.w * sizeRelativeTo._1
    val h = positionInParent.h * sizeRelativeTo._2
    (x,y,w,h)
  }
}

object Page {
  def title = document.head.title
  def title_=(s: String) = document.head.title = s
  
  object Body extends Node {
    val web = document.body
    val template: Template = new Template {
      def offsetRelativeTo: (Double, Double) = (0,0)
      def sizeRelativeTo: (Double, Double) = (window.innerWidth,pageHeight)
      def positionInParent: BoundingBox = (0,0,1,1)
    }
    var pageHeight = window.innerHeight
    web.style.padding = "0"
    web.style.margin = "0"
    web.style.border = "0"
    web.style.overflowX = "hidden"
    //web.style.overflowY = "auto"
    window.onpageshow = (_) => {
      pageHeight = window.innerHeight
      setSize()
    }
    window.onresize = (_) => {
      pageHeight = window.innerHeight
      setSize()
      println(s"updated size to $pageHeight")
    }
  }

}