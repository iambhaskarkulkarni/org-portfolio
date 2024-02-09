<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Sending Email with Freemarker HTML Template Example</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>

    <!-- use the font -->
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            font-size: 48px;
        }
    </style>
</head>
<body style="margin: 0; padding: 0;">

<table align="center" border="0" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
    <tr>
        <td align="center" bgcolor="#78ab46" style="padding: 40px 0 30px 0;">
            <img src="cid:logo.png" alt="https://www.techmagister.info" style="display: block;" />
        </td>
    </tr>
    <tr>
        <td bgcolor="#eaeaea" style="padding: 40px 30px 40px 30px;">
            <p>Dear ${name},</p>
            <p>Thank you for reaching out to [Your Company Name]! We have received your [inquiry/message] and want to express our gratitude for your interest in our [products/services]. Your communication is important to us, and we are committed to providing you with a timely and helpful response.</p>
            <P>Our team is currently reviewing your request, and we aim to get back to you as soon as possible. Please allow us [mention a specific timeframe if applicable] to thoroughly assess your inquiry and provide you with the information or assistance you are seeking.</p>
            <p>We appreciate your patience and understanding as we work to provide you with the best possible assistance. If you have any urgent matters or if there's anything else you'd like to share in the meantime, please don't hesitate to contact us at [your contact information].</P>
            <p>Once again, thank you for choosing [Your Company Name]. We look forward to the opportunity to serve you.</p>
            <#--<p>CLick here to verify your email <b>${token}</b></p>-->
            <p>Thanks</p>
        </td>
    </tr>
    <tr>
        <td bgcolor="#777777" style="padding: 30px 30px 30px 30px;">
            <p>${signature}</p>
            <p>${location}</p>
        </td>
    </tr>
</table>

</body>
</html>