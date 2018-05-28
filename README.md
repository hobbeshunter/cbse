% Example Eclipse Workspace with OSGi
% Christian Piechnick and Thomas Kühn
% 9.5.2018

# Installation

* Unzip the example archive `example.zip`
* Start eclipse and "Switch Workspace" to the "osgi" folder 
* Enable Automatic Build *(Project —> Build Automatically)*
* Build the workspace *(Project —> Build All)*
* The workspace has already a preconfigured run configuration “OSGi Framework”
* Use run “OSGi framework” to start the `OSGi` and the console
* See the console output
* Play with the console commands[^1]

[^1]: http://www.vogella.com/tutorials/OSGi/article.html#the-osgi-console

# Application

* Contains four bundles, such as `OSGIMinimalExample`, `CommonTypes`, `ComponentA`, `ComponentB`)
* Every bundle has an `Activator` class and a `Manifest` file
* `CommonTypes` captures datatypes, e.g., Service interfaces that are needed by all components and is included in the main project `OSGIMinimalExample`
- `OSGIMinimalExample` is the main bundle and has dependencies to all other bundles (see the `MANIFEST.MF` for details)
- `ComponentB` offers `ServiceB` class as implementation of the `IServiceB` interface
- `ComponentA` offers `ServiceA` class as implementation of the `IServiceA` interface
- `ComponentA` in turn requires an instance of `IServiceB` (see implementation of `ServiceA` for details)
