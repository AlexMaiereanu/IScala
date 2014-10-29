package org.refptr.iscala

import org.refptr.iscala.json.{Json,JsonImplicits}

case class Connection(
    ip: String,
    transport: String,
    stdin_port: Int,
    control_port: Int,
    hb_port: Int,
    shell_port: Int,
    iopub_port: Int,
    key: String,
    signature_scheme: Option[String])

object Connection {
    import JsonImplicits._
    implicit val ConnectionJSON = Json.format[Connection]

    lazy val default = {
        val port0 = 5678
        Connection(ip="127.0.0.1",
                   transport="tcp",
                   stdin_port=port0,
                   control_port=port0+1,
                   hb_port=port0+2,
                   shell_port=port0+3,
                   iopub_port=port0+4,
                   key=UUID.uuid4().toString,
                   signature_scheme=None)
    }
}
