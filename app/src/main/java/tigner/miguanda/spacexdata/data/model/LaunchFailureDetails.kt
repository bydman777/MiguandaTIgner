package tigner.miguanda.spacexdata.data.model

data class LaunchFailureDetails(
    val altitude: Int,
    val reason: String,
    val time: Int
)