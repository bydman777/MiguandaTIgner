package tigner.miguanda.spacexdata.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tigner.miguanda.spacexdata.data.network.SpaceXApi
import tigner.miguanda.spacexdata.util.Constants
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLaunchApi(): SpaceXApi{
        return  Retrofit.Builder()
            .baseUrl(Constants.PATH_SPACE_X_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SpaceXApi::class.java)
    }


}