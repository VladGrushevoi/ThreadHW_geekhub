package com.vladgrushevoy.geekhwthread

import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.vladgrushevoy.geekhwthread.MainActivity.Companion.CURR_POSITION
import com.vladgrushevoy.geekhwthread.MainActivity.Companion.DEFAULT_VALUE
import com.vladgrushevoy.geekhwthread.MainActivity.Companion.PROGRESS
import java.util.concurrent.TimeUnit

class MyWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        var currentPosition = inputData.getInt(CURR_POSITION, DEFAULT_VALUE)
        while (!this.isStopped && currentPosition < Short.MAX_VALUE) {
            if (isPrime(currentPosition)) {
                setProgressAsync(Data.Builder().putInt(PROGRESS, currentPosition).build())
                TimeUnit.MILLISECONDS.sleep(1000)
            }
            currentPosition++
        }
        return Result.success()
    }

    private fun isPrime(number: Int): Boolean {
        if (number <= 1) {
            return false
        }
        for (i in 2 until number)
            if (number % i == 0) {
                return false

            }
        return true
    }
}