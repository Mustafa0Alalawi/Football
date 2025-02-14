package o1.football3

import scala.collection.mutable.Buffer


class Match(val home: Club, val away: Club):

  private val homeScorers = Buffer[Player]()    // container: goalscorers of the home team are added here
  private val awayScorers = Buffer[Player]()    // container: goalscorers of the away team are added here

  def allScorers: Vector[Player] = (homeScorers ++ awayScorers).toVector

  def homeGoals: Int = this.homeScorers.length

  def awayGoals: Int = this.awayScorers.length

  def totalGoals: Int = this.homeGoals + this.awayGoals

  def isHomeWin: Boolean = this.homeGoals > this.awayGoals

  def isAwayWin: Boolean = this.homeGoals < this.awayGoals

  def isTied: Boolean = this.homeGoals == this.awayGoals

  def isGoalless: Boolean =  totalGoals == 0

  def isHigherScoringThan(anotherMatch: Match) =
    this.totalGoals > anotherMatch.totalGoals

  def goalDifference = this.homeGoals - this.awayGoals

  def location: String = home.stadium

  def hasScorer(possibleScorer: Player): Boolean =
  homeScorers.contains(possibleScorer) || awayScorers.contains(possibleScorer)

  def winner: Option[Club] =
    if (this.isHomeWin) then
      Some(this.home)
    else if (this.isAwayWin) then
      Some(this.away)
    else
      (None)

  def winnerName =
    if this.isTied then
      "no winner"
    else
      winner.get.name


  def addGoal(scorer: Player): Unit =
    if scorer.employer == this.home then
      this.homeScorers += scorer
    else this.awayScorers += scorer

  override def toString: String =
    s"${home.name} vs. ${away.name} at ${home.stadium}: " +
      s"${if this.homeGoals == 0 && this.awayGoals == 0
            then "tied at nil-nil"
          else if this.homeGoals == this.awayGoals
            then "tied at "+ homeGoals +"-all"
          else if isHomeWin
            then s"${homeGoals}-${awayGoals} to ${home.name}"
          else s"$awayGoals-$homeGoals to ${away.name}"
      }"


  def winningScorer: Option[Player] =

  if this.isTied then None

  else if this.isHomeWin then Some(homeScorers(awayGoals))

  else Some(awayScorers(homeGoals))




end Match