### Observability

link: https://dzone.com/articles/developing-rest-apis

Once API is deployed in production, it does not mean we can forget about the API. 

Production deployment kicks off another phase of testing — testing in production that may uncover issues 
that remained uncaught in earlier phases. 
Testing in production includes a set of activities clubbed together as observability that includes logging, monitoring, and tracing. 

The tools for these activities will help us to diagnose and resolve issues found in production.

* Logging — Logging needs to be done explicitly by the developers using their preferred logging framework 
  and a logging standard. For example, one log statement for every 10 lines of code 
  or more if the code is complex with log levels split as: 
  60 percent DEBUG, 25 percent INFO, 10 percent WARN and 5 percent ERROR.

* Monitoring — Monitoring runs at a higher level than logging. 
  While logging explicitly tells us what is going on with the API, monitoring provides the overall health of API 
  using generic metrics exposed by the platform and the API itself. 
  Metrics are typically exposed by an agent deployed on the server 
  or it may be part of the solution and are collected periodically by the monitoring solution deployed remotely.

* Diagnostic endpoints may be included in the solution that tells us the overall health of the API.

**Tracing** — Zipkin is a distributed tracing system. It helps gather timing data needed to troubleshoot 
latency problems in microservice architectures.

Enabling Centralized Logging covers logging and tracing. 
For **monitoring**, interesting metrics may be stored in a time-series store like Prometheus and visualized using Grafana.