package o1.football3

import scala.None
import scala.collection.mutable.Buffer


class Season():

  private val matches = Buffer[Match]()

  def addResult(newResult: Match): Unit =
    matches += newResult

  def latestMatch: Option[Match] =
    matches.lastOption

  def matchNumber(number: Int): Option[Match] =
    if number >= 0 && number < matches.size then
      Some(matches(number))
    else
      None

  def numberOfMatches: Int =
    matches.size

  def biggestWin: Option[Match] =
    if matches.isEmpty then
      None
    else
      var largestWin = matches.head
      for (currentMatch <- matches) do
        if math.abs(currentMatch.goalDifference) > math.abs(largestWin.goalDifference) then
          largestWin = currentMatch
      Some(largestWin)

end Season










