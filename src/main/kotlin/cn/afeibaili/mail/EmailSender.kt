package cn.afeibaili.ipv6toipv4.cn.afeibaili.mail

import jakarta.mail.*
import jakarta.mail.internet.InternetAddress
import jakarta.mail.internet.MimeMessage
import java.util.*


/**
 * 邮箱构建器
 *
 *@author AfeiBaili
 *@version 2026/2/4 18:57
 */

class EmailSender(
    val sender: String,
    val authCode: String,
    smtpUrl: String,
    smtpPort: Int,
) {
    val props: Properties = buildProperties(
        "mail.smtp.host" to smtpUrl,
        "mail.smtp.port" to smtpPort.toString(),
        "mail.smtp.auth" to "true",
        "mail.smtp.ssl.enable" to "true",
    )

    val session: Session = Session.getInstance(props, object : Authenticator() {
        override fun getPasswordAuthentication(): PasswordAuthentication? {
            return PasswordAuthentication(sender, authCode)
        }
    })

    fun send(mail: Mail) {
        val message = MimeMessage(session)
        message.setFrom(InternetAddress(sender))
        message.setRecipient(Message.RecipientType.TO, InternetAddress(mail.receiver))
        message.subject = mail.title
        message.setContent(mail.content, "text/html; charset=utf-8")

        Transport.send(message)
        println("发送一个邮件：${mail}")
    }
}