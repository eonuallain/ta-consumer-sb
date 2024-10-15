#!/usr/bin/env python
import pika

queue_name='hello'
routing_key=queue_name
body='Hello World2!'

connection = pika.BlockingConnection(
    pika.ConnectionParameters(host='localhost')
)
channel = connection.channel()

channel.queue_declare(queue=queue_name)

channel.basic_publish(exchange='', routing_key=routing_key, body=body)
print(f" [x] Sent '{body}'")
connection.close()