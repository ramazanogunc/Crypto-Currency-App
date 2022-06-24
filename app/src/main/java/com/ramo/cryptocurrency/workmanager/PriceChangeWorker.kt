package com.ramo.cryptocurrency.workmanager

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.ramo.cryptocurrency.domain.usecase.PriceChangeUseCase
import com.ramo.cryptocurrency.utils.NotificationHelper
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class PriceChangeWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val priceChangeUseCase: PriceChangeUseCase
) : CoroutineWorker(appContext, workerParams) {

    companion object {
        const val TAG = "PriceChangeWorker"
    }

    override suspend fun doWork(): Result {
        var notificationBody = ""
        val change = priceChangeUseCase.execute(null)
        change.forEach {
            notificationBody += "${it.coinDetail.name} is changed: Range is ${it.changePercentRange}\n"
        }
        if (notificationBody.isBlank()) return Result.success()
        else notificationBody = notificationBody.dropLast(2)
        NotificationHelper.sendNotification(applicationContext, notificationBody)
        return Result.success()

    }


}