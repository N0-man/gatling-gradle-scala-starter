package simulations

import infrastructure.{BaseSimulation, Load}
import registries.Explore

class HighTrafficLoad extends BaseSimulation {
  setUp("Explore High Traffic Load", Load.High, Explore.possibleCalls)
}
