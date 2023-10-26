package com.yonatanrs.moviedatabase.core.di.module

import com.google.gson.GsonBuilder
import com.yonatanrs.moviedatabase.core.BuildConfig
import com.yonatanrs.moviedatabase.core.data.gson.jsondeserializer.AvatarUrlStringDeserializer
import com.yonatanrs.moviedatabase.core.data.gson.jsondeserializer.ImageUrlStringDeserializer
import com.yonatanrs.moviedatabase.core.domain.entity.urlstring.AvatarUrlString
import com.yonatanrs.moviedatabase.core.domain.entity.urlstring.ImageUrlString
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .registerTypeAdapter(ImageUrlString::class.java, ImageUrlStringDeserializer())
                        .registerTypeAdapter(AvatarUrlString::class.java, AvatarUrlStringDeserializer())
                        .setLenient()
                        .create()
                )
            )
            .build()
    }
}