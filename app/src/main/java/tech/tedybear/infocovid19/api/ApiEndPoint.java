package tech.tedybear.infocovid19.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import tech.tedybear.infocovid19.model.CountryModel;
import tech.tedybear.infocovid19.model.RingkasanModel;
import tech.tedybear.infocovid19.model.RiwayatModel;

/*
 * Created by Mochammad Tedy Fazrin on 3/23/20 5:33 PM
 * Copyright (c) 2020. All rights reserved.
 */

public interface ApiEndPoint {

    @GET(Api.END_POINT_WORLD_HISTORY)
    Call<List<RiwayatModel>> getHistoryList(@Path("date") String date);

    @GET(Api.END_POINT_SUMMARY_WORLD)
    Call<RingkasanModel> getSummaryWorld();

    @GET(Api.END_POINT_IDN)
    Call<CountryModel> getSummaryIdn();

}
