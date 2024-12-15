### Render

Render helps software teams ship products fast and at any scale.
We host everything from hundred-line prototypes to applications with hundreds of services,
all with a relentless commitment to reliability and uptime.

#### Configuration

###### Server port

The default value of PORT is 10000 for all Render web services.
You can override this value by setting the environment variable for your service in the Render Dashboard.

```
issue: 
New primary port detected: 10000. 
Restarting deploy to update network configuration...
==> Docs on specifying a port: https://render.com/docs/web-services#port-binding

process.env.PORT

const port = process.env.PORT || 4000;
```