package Base
import java.io.Serializable
data class Team(
    val ID: String,
    val TeamName: String,
    val Matches: String,
    val Wins: String,
    val Image: String,
    val Looses: String,
    val Draws: String,
    val Difference: String
):Serializable

object TeamsDB{
    private val Team = mutableListOf(
        Team(
            ID = "1",
            TeamName = "Fc Barcelona",
            Matches = "10",
            Wins = "8",
            Looses = "1",
            Draws = "1",
            Difference = "18",
            Image="https://banner2.cleanpng.com/20190223/bqv/kisspng-fc-barcelona-logo-vector-graphics-football-image-5c71e478167a69.5648857315509679280921.jpg",
        ),
        Team(
            ID = "2",
            TeamName = "Real Madrid",
            Matches = "10",
            Wins = "10",
            Looses = "0",
            Draws = "0",
            Difference = "23",
        )
    )
}
