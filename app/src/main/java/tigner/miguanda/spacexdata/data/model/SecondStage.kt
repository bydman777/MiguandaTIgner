package tigner.miguanda.spacexdata.data.model

data class SecondStage(
    val block: Int,
    val payloads: List<Payload>
)