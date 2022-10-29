# mailslurper
testing mailslurper docker + small app sending emails

## Docker

Testing with this image: https://hub.docker.com/r/adampresley/mailslurper

```docker
docker pull adampresley/mailslurper
```

```docker
docker run -p 8080:8080 -p 8085:8085 -p 2500:2500 adampresley/mailslurper --name mailslurper
```

Opening the web console: <http://localhost:8080/>

## Sending an email

### Python

Trying to write a small Python programm. Following this guide: [Sending Emails With Python](https://realpython.com/python-send-email)

#### Setting up a Local SMTP Server

```python
python -m smtpd -c DebuggingServer -n localhost:1025
```
