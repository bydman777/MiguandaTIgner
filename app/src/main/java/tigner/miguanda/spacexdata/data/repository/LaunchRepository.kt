package tigner.miguanda.spacexdata.data.repository

import retrofit2.HttpException
import tigner.miguanda.spacexdata.data.network.SpaceXApi
import tigner.miguanda.spacexdata.data.repository.Response.Error
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

class LaunchRepository @Inject constructor(private val api: SpaceXApi) : Repository{

    override suspend fun getAllLaunches(): Response<Any> {

        val response = try {
            api.getAllLaunches()
        } catch (e: IOException) {
            Timber.e("IOException, ${e.message}")
            return Error("IO ERROR ${e.message}")
        } catch (e: HttpException) {
            Timber.e("HttpException, ${e.message}")
            return Error( "HTTP ERROR ${e.message}")
        }
        return if (response.isSuccessful && response.body() != null) {
            Response.Success(response.body()!!)
        } else {
            Timber.e("Response not successful")
            Error( "Response ERROR")
        }
    }

    override suspend fun getLaunchByFlightNumber(number: Int): Response<Any> {
        val response = try {
            api.getLaunchByFlightNo(number)
        } catch (e: IOException) {
            Timber.e("IOException, ${e.message}")
            return Error("IO ERROR ${e.message}")
        } catch (e: HttpException) {
            Timber.e("HttpException, ${e.message}")
            return Error( "HTTP ERROR ${e.message}")
        }
        return if (response.isSuccessful && response.body() != null) {
            Response.Success(response.body()!!)
        } else {
            Timber.e("Response not successful")
            Error( "Response ERROR")
        }
    }
}