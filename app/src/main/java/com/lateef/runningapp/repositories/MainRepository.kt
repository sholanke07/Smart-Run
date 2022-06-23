package com.lateef.runningapp.repositories

import com.lateef.runningapp.data.db.RunDao
import com.lateef.runningapp.model.Run
import javax.inject.Inject

class MainRepository @Inject constructor(val runDao: RunDao) {

    suspend fun insertRun(run: Run) = runDao.insertRun(run)

    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)

    fun getAllRunsSortedByDate() = runDao.getAllRunsSortedByData()

    fun getAllRunsSortedByDistance() = runDao.getAllRunsSortedByDistance()

    fun getAllRunsSortedByTimeInMillis() = runDao.getAllRunsSortedByTimeInMillis()

    fun getAllRunsSortedByAvgSpeed() = runDao.getAllRunsSortedByAvgSpeed()

    fun getAllRunsSortedByCaloriesBurned() = runDao.getAllRunsSortedByCaloriesBurned()


    fun getTotalAvgSpeed() =runDao.getTotalAvgSpeed()

    fun getTotalDistance() =runDao.getTotalDistanceMeters()

    fun getTotalTimeInMillis() =runDao.getTotalTimeInMillis()

    fun getTotalCaloriesBurned() =runDao.getTotalCaloriesBurned()

}