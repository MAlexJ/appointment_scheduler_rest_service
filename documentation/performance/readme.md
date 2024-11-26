Performance REST api tests

link: https://dzone.com/articles/developing-rest-apis

In this section, we will look at tools to load test our API so that we can quantify
how much traffic our infrastructure can cope with.
The basic idea behind performance testing is to send lots of requests to the API at the same time
and see at what point performance degrades and ultimately fails.

The answers we look for are:

* What response times can the API give under different load conditions?
* How many concurrent requests can the API handle without errors?
* What infrastructure is required to deliver the desired performance?

loader.io is a cloud-based free load testing service that allows us to stress test our APIs.
To get a baseline performance of API, different kinds of load tests can be run with increasing loads,
measured by the number of requests per second, to find out performance figures quantified by errors and response times,
for:

* `Soak test` — average load for long periods, e.g., run for 48 hours @1 request per second.
  This will uncover any memory leaks or other similar latent bugs.
* `Load test` — peak load, e.g., run 2K requests per second with 6 instances of API.
* `Stress test` — way-over peak load, e.g., run10K requests per second for 10 minutes.

This also lets us decide the infrastructure that will let us deliver API with desired performance numbers
and whether our solution scales linearly.

### Loader.io

Loader.io is a FREE load testing service that allows you to stress test
your web-apps & apis with thousands of concurrent connections.

https://support.loader.io/category/14-getting-started

#### Creating a Test

link: https://support.loader.io/article/15-creating-a-test
