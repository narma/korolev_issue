package myapp

import akka.actor.ActorSystem

object Application  extends App {

  implicit val system: ActorSystem = ActorSystem("scala_bug")

}
