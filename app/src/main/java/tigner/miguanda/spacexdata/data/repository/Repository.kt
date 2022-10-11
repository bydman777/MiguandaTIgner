package tigner.miguanda.spacexdata.data.repository


interface Repository {

    suspend fun getAllLaunches():Response<Any>
    suspend fun getLaunchByFlightNumber(number:Int):Response<Any>

}