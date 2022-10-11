package tigner.miguanda.spacexdata.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import tigner.miguanda.spacexdata.data.model.Launch
import tigner.miguanda.spacexdata.util.Constants

/**
 * Retrofit API
 */
interface SpaceXApi {

    /**
     * get a list of all high schools available
     */
    @GET(Constants.PATH_LAUNCH_LIST)
    suspend fun getAllLaunches(): Response<List<Launch>>

    /**
     * Get a list of all available schools based on its dbn
     */
    @GET(Constants.PATH_LAUNCH_BY_FLIGHT_NO)
    suspend fun getLaunchByFlightNo(@Path("no") flightNumber: Int): Response<Launch>
}