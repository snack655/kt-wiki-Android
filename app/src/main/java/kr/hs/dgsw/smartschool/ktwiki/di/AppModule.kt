package kr.hs.dgsw.smartschool.ktwiki.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.smartschool.ktwiki.common.Constants
import kr.hs.dgsw.smartschool.ktwiki.data.remote.KTwikiApi
import kr.hs.dgsw.smartschool.ktwiki.data.repository.KTwikiRepositoryImpl
import kr.hs.dgsw.smartschool.ktwiki.domain.repository.KTwikiRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideKTwikiApi(): KTwikiApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KTwikiApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: KTwikiApi): KTwikiRepository {
        return KTwikiRepositoryImpl(api)
    }
}