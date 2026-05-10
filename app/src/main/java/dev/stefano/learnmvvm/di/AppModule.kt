package dev.stefano.learnmvvm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.stefano.learnmvvm.data.repository.CounterRepository
import dev.stefano.learnmvvm.data.repository.CounterRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideCounterRepository(): CounterRepository = CounterRepositoryImpl()
}