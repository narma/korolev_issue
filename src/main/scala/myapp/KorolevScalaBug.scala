package myapp

import korolev._
import korolev.execution._
import korolev.state.javaSerialization._
import scala.concurrent.Future

case class MyState(enabled: Boolean)

object MyState {
  val globalContext = Context[Future, MyState, Any]
}

class MyApp {
  import MyState.globalContext._
  import symbolDsl._

  private def render: Render = {
    case st =>
      'body (
        'input ('type /= "radio",
          'name /= s"foobar",
          if (st.enabled) void
          else 'disabled /= "true")
      )
  }
}
