package infrastructure

import io.gatling.core.Predef._
import org.slf4j.{Logger, LoggerFactory}

import scala.language.postfixOps

abstract class BaseSimulation extends Simulation {

  def setUp(name: String, load: TrafficLoadConfiguration, possibilities: List[Possibility]): SetUp = {

    val logger: Logger = LoggerFactory.getLogger(this.getClass)
    val scn = scenario(name).exec({ session => logger.info(session.toString); session })
    setUp(
      scenario(name)
        .exec(randomSwitch(Possibilities.balance(load, possibilities): _*))
        .inject(
          //Meta DSL
          incrementUsersPerSec(load.incrementUsersPerSec)
            .times(load.repeatLevels)
            .eachLevelLasting(load.eachLevelLasting)
            .startingFrom(load.startingRate)
            .separatedByRampsLasting(load.rampDuration)

          /** Closed Systems - where the system can only physically support a certain load. Examples of this would
            * be a call center where you only have a limited number of agents or a waiting room where users take a
            * ticket and wait in a queue to be served once the capacity is full
            */
//          constantConcurrentUsers(10) during (10 seconds),
//          rampConcurrentUsers(10) to 20 during (10 seconds)

//          incrementUsersPerSec(5.0)
//            .times(2)
//            .eachLevelLasting(1.minutes)
//            .startingFrom(10) // Double
//            .separatedByRampsLasting(10)

          /** Open Systems - where the system will continue trying to serve new users arriving, even if already
            * at 'peak' load. Most websites behave in this way.
            */
          //Open Systems example
//          nothingFor(4), // 1
//          atOnceUsers(10), // 2
//          rampUsers(10).during(5), // 3
//          constantUsersPerSec(20).during(15), // 4
//          constantUsersPerSec(20).during(15).randomized, // 5
//          rampUsersPerSec(10).to(20).during(10.minutes), // 6
//          rampUsersPerSec(10).to(20).during(10.minutes).randomized, // 7
//          stressPeakUsers(1000).during(20) // 8
        )
        .protocols(Protocols.default)
    )
  }
}
