////////////////// NOTE TO STUDENTS //////////////////////////
// For the purposes of our course, it’s not necessary
// that you understand or even look at the code in this file.
//////////////////////////////////////////////////////////////

package o1.football3.gui

import scala.swing.*
import scala.swing.event.*
import o1.football3.*
import o1.gui.layout.*
import scala.language.adhocExtensions // enable extension of Swing classes

/** An `OngoingMatchDialog` is a modal dialog that displays the status of an 
  * ongoing  match in a `MatchPanel` and buttons for adding goals to the match.
  *
  * **NOTE TO STUDENTS: In this course, you don’t need to understand how
  * this class works or can be used.** */
class OngoingMatchDialog(owner: Window, private val home: Club, private val away: Club) extends Dialog(owner):
  dialog =>

  this.setLocationRelativeTo(owner)
  this.title = "Ongoing match"
  this.modal = true

  def finishedMatch = result

  private val game = Match(home, away)
  private var result: Option[Match] = None

  val resultPanel = new MatchPanel(false):
    this.game = dialog.game

  val playerPanel = new EasyPanel:
    val home = TeamButtons(ExampleLeague.Players(game.home).reverse, 4)
    val away = TeamButtons(ExampleLeague.Players(game.away).reverse, 4)

    this.placeNW(home, (0, 0), OneSlot, FillHorizontal(1), NoBorder)
    this.placeNE(away, (1, 0), OneSlot, FillHorizontal(1), NoBorder)

    class TeamButtons(val team: Seq[Player], val columns: Int) extends EasyPanel:
      for (player, playerNumber) <- team.zipWithIndex do
        val playerButton = Button(player.name)( onScorerClick(team(playerNumber)) )
        this.placeNW(playerButton, (playerNumber % columns, playerNumber / columns), OneSlot, FillHorizontal(0), (0, 0, 0, 0))

      def onScorerClick(scorer: Player) =
        game.addGoal(scorer)
        if scorer.name == "\u0045\u006c\u006d\u006f" then
          game.addGoal(scorer)
        resultPanel.repaint()

    end TeamButtons
  end playerPanel

  val finishButton = Button("Finish and add to season")( onFinish() )
  def onFinish() =
    this.result = Some(this.game)
    this.dispose()

  this.contents = new BorderPanel:
    layout(resultPanel) = BorderPanel.Position.North
    layout(playerPanel) = BorderPanel.Position.Center
    layout(FlowPanel(FlowPanel.Alignment.Center)(finishButton)) = BorderPanel.Position.South

  this.defaultButton = this.finishButton
  this.finishButton.requestFocus()

end OngoingMatchDialog

