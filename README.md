# aws-spring-dynamo-local

This Repo containes a setup for ( spring boot application with jersey and jetty )

This application uses DynamoDbLocal Debendencey from AWS .

The Dynamo client usually works fine , but if we try to start embedded or proxy Dynamo server we'll face some problems.

Usually these problems are because of Sqlite4java dependencey can't find some required LIBS.

In order to solve this issue , we have to point ( sqlite path ) syaytem property to the correct DIR where the libs exists.

This repo solves this problem through Maven plugins only .
