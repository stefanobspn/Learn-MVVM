package dev.stefano.learnmvvm.data

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.stefano.learnmvvm.data.model.CounterModel
import dev.stefano.learnmvvm.data.repository.CounterDao

@Database(entities = [CounterModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun counterDao(): CounterDao
}