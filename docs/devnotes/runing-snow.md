
# Running BetaGo Snow

BetaGo Snow uses the ASP.NET Core server backend by 0xFireball that is contributed
as part of upstream BetaGo.

The server must be run on `localhost` on the development machine.
Since we want to be able to debug the server while debugging the app,
we point the app to use the local instance as a service. Therefore,
the Android Kotlin source code is configured to use a service on `10.0.2.2`
in debug builds, and use a production server in release builds.