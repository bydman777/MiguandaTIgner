package tigner.miguanda.spacexdata.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tigner.miguanda.spacexdata.data.repository.LaunchRepository
import tigner.miguanda.spacexdata.data.repository.Repository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindHighSchoolRepository(
        highSchoolRepository: LaunchRepository
    ): Repository
}