package myapp

import korolev._
import korolev.execution._
import korolev.server._
import korolev.state.javaSerialization._
import korolev.state.{DeviceId, SessionId, StateStorage}

import scala.concurrent.Future

case class MyState(enabled: Boolean = true)

object MyState {
  val globalContext = Context[Future, MyState, Any]
}

class KorolevApp() {
  import MyState.globalContext._
  import symbolDsl._

  val formId = elementId()

  private def render: Render = {
    case st =>
      'body (
        'form (
          formId,
          'input ('type /= "checkbox", 'name /= s"foobar"),
          'button ("Upload", event('click) { access =>
            for {
              formData <- access.downloadFormData(formId).start()
              _ = println(s"formData: $formData")
            } yield ()
          })
        )
      )
  }

  val config = KorolevServiceConfig[Future, MyState, Any](
    stateStorage = StateStorage.default(MyState()),
    router = { (_: DeviceId, _: Option[SessionId]) =>
      Router.empty[Future, MyState, Option[MyState]]
    },
    render = render
  )
}
