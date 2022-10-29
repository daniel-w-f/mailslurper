import smtplib, ssl

# smtp_server = "smtp.gmail.com"
smtp_server = "localhost"
# port = 587  # For starttls
# Local Python DebuggingServer
port = 1025
sender_email = "my@gmail.com"
# password = input("Type your password and press enter: ")
password = "abc"

# Create a secure SSL context
context = ssl.create_default_context()

# Try to log in to server and send email
try:
    server = smtplib.SMTP(smtp_server,port)
    server.ehlo() # Can be omitted
    # server.starttls(context=context) # Secure the connection
    server.starttls(context) # Secure the connection
    server.ehlo() # Can be omitted
    server.login(sender_email, password)
    # TODO: Send email here

    # sender_email = "my@gmail.com"
    receiver_email = "your@gmail.com"
    message = """\
    Subject: Hi there

    This message is sent from Python."""

    # Send email here
    server.sendmail(sender_email, receiver_email, message)

except Exception as e:
    # Print any error messages to stdout
    print(e)
finally:
    server.quit()
