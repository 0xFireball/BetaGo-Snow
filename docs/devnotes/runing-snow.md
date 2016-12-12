
# Running BetaGo Snow

BetaGo Snow uses the ASP.NET Core server backend by 0xFireball that is contributed
as part of upstream BetaGo.

The server must be run on `localhost` on the development machine.
Since we want to be able to debug the server while debugging the app,
we point the app to use the local instance as a service. Therefore,
the Android Kotlin source code is configured to use a service on `10.0.2.2`
in debug builds, and use a production server in release builds.
The following instructions assume that you are using the Android Studio
emulator. If you are using a physical device or other emulator, be sure
to update the IP address of the server to point to your development machine.

## Quick Start

1. Launch the app in `debug` configuration on the target device
1. Follow the instructions to launch the server on the development machine
1. The app should be able to connect to the server. To troubleshoot,
open the server sources in an environment with a .NET Core debugger and
set a couple breakpoints.