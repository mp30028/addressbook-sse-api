Address Book back-end application.

Uses JPA to interact with a MySQL database with a JPA Listener to listen for CRUD events.

When the JPA-CRUD events are triggered a handler re-publishes them as Persistence-Events to a Reactor-Flux where Reactive Listeners can pick them up.

There is a Web-Socket Reactive-Listener configured to pick up Persistence-Events published so that they can be displayed in a Web-Browser. The same events are handled by functionality for Server Sent Events. SSE pushes these events to any listening browser once the browser registers to listen on /sse/persons endpoint.

### UI
There is a react UI which consumes and displays the data available in [addressbook-sse-ui repostiory](https://github.com/mp30028/addressbook-sse-ui)
