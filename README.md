Gatling plugin for Gradle - Starter
==============================================

A simple showcase of a Gradle project using the Gatling plugin for Gradle. Refer to the plugin documentation
[on the Gatling website](https://gatling.io/docs/current/extensions/gradle_plugin/) for usage.

This project is written in Scala, others are available for [Java](https://github.com/gatling/gatling-gradle-plugin-demo-java)
and [Kotlin](https://github.com/gatling/gatling-gradle-plugin-demo-kotlin).

Running locally

Simulations can be run locally using Gradle. `./gradlew gatlingRun` runs all simulations, `./gradlew gatlingRun-simulations.ComputerDatabaseSimulation` runs the specific simulation.

It includes:

* Gradle Wrapper, so you don't need to install Gradle (a JDK must be installed and $JAVA_HOME configured)
* minimal `build.gradle` leveraging Gradle wrapper
* latest version of `io.gatling.gradle` plugin applied
* sample [Simulation](https://gatling.io/docs/gatling/reference/current/general/concepts/#simulation) class,
demonstrating sufficient Gatling functionality
* proper source file layout

### Structure

> 📁 infrastructure
> - `BaseSimulation` : Open System based Meta DSL for simulating different loads
> - `Possibility` : Base object to represent possibilities for Features / User flows in the registries
> - `Protocol` : http protocol for running simulations
> - `TrafficLoadConfiguration` : 3 load configurations such as Standard, High and Peak

> 📁 registries : All features / user flow objects registries to represents various possibilities

> 📁 simulations : All simulations / tests 

### Running specific simulation

⭕️ **Standard Traffic Load** `./gradlew gatlingRun-simulations.StandardTrafficLoad` \
⭕️ **High Traffic Load** `./gradlew gatlingRun-simulations.HighTrafficLoad` \
⭕️ **Peak Traffic Load** `./gradlew gatlingRun-simulations.PeakTrafficLoad`

