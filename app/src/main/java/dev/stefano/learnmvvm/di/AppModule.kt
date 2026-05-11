package dev.stefano.learnmvvm.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.stefano.learnmvvm.data.AppDatabase
import dev.stefano.learnmvvm.data.repository.CounterDao
import dev.stefano.learnmvvm.data.repository.CounterRepository
import dev.stefano.learnmvvm.data.repository.CounterRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "counter_db"
        ).build()
    }

    @Provides
    fun provideCounterDao(db: AppDatabase): CounterDao {
        return db.counterDao()
    }

    @Provides
    fun provideCounterRepository(dao: CounterDao): CounterRepository {
        return CounterRepositoryImpl(dao)
    }
}