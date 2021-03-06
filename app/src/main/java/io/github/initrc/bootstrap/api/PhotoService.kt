package io.github.initrc.bootstrap.api

import io.github.initrc.bootstrap.model.PhotoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 500px photo service.
 */
interface PhotoService {
    @GET("photos")
    fun getPhotos(@Query("feature") feature: String,
                  @Query("page") page: Int,
                  @Query("exclude") exclude: String = ApiConstants.exclude,
                  @Query("image_size") imageSize: Int = ApiConstants.defaultImageSize,
                  @Query("consumer_key") consumerKey: String = ApiSecrets.consumerKey)
            : Call<PhotoResponse>
}
