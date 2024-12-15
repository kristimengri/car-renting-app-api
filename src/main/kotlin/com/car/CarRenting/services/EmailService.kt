package com.car.CarRenting.services

import com.car.CarRenting.enums.EmailTemplateName
import jakarta.mail.MessagingException
import jakarta.mail.internet.MimeMessage
import lombok.RequiredArgsConstructor
import lombok.Value
import org.springframework.context.annotation.Bean
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.mail.javamail.MimeMessageHelper.MULTIPART_MODE_MIXED
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.thymeleaf.context.Context
import org.thymeleaf.spring6.SpringTemplateEngine
import java.nio.charset.StandardCharsets.UTF_8
import java.util.*
import kotlin.collections.HashMap
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.*

@Service
@RequiredArgsConstructor
class EmailService(
    private val mailSender: JavaMailSender,
    private val templateEngine: SpringTemplateEngine

) {


    @Throws(MessagingException::class)
    fun sendEmail(
        to: String,
        username: String,
        emailTemplate: EmailTemplateName,
        confirmationUrl: String,
        activationCode: String,
        subject: String

    ) {



        try {
            val templateName: String = "activate_account"

            // Create the MIME message
            val mimeMessage: MimeMessage = mailSender.createMimeMessage()
            val helper = MimeMessageHelper(
                mimeMessage,
                MimeMessageHelper.MULTIPART_MODE_MIXED,
                "UTF-8"
            )

            // Prepare the context with email properties
            val properties = mapOf(
                "username" to username,
                "confirmationUrl" to confirmationUrl,
                "activation_code" to activationCode
            )

            val context = Context().apply {
                setVariables(properties)
            }

            // Set email details
            helper.setFrom("intelligencea61@gmail.com")
            helper.setTo(to)
            helper.setSubject(subject)

            // Process the email template
            val template: String = templateEngine.process(templateName, context)
            helper.setText(template, true)  // Set the email content as HTML

            // Send the email
            mailSender.send(mimeMessage)

        } catch (e: MessagingException) {
            // Log the error and throw exception if necessary
            e.printStackTrace()  // For production, use a logging framework like SLF4J
            throw e
        }

 }
}