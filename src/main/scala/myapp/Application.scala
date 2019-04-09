package myapp

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.{ActorMaterializer, Materializer}
import korolev.akkahttp._
import korolev.execution._
import korolev.state.javaSerialization._

object Application extends App {

  implicit val system: ActorSystem = ActorSystem("korolev")
  implicit val materializer: Materializer = ActorMaterializer()

  val app = new KorolevApp

  val korolevRoute = akkaHttpService(app.config).apply(AkkaHttpServerConfig())

  Http().bindAndHandle(korolevRoute, "0.0.0.0", 8080)

}
