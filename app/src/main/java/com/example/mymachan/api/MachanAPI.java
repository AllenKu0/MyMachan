package com.example.mymachan.api;

import com.example.mymachan.api.pojo.response.OrgVResponse;
import com.example.mymachan.api.pojo.response.PersonVResponse;
import com.example.mymachan.api.pojo.response.SupplierVResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by 5*N on 2017/12/28
 */

public interface MachanAPI {

    @GET
    Observable<List<OrgVResponse>> getOrgV(@Url String mOrgV);
//
//    @GET
//    Observable<List<MaterialGroupVResponse>> getMaterialGroupV(@Url String mMaterialGroupV);
//
//    @GET
//    Observable<List<BizPartnerVResponse>> getBizPartnerV(@Url String mBizPartnerV);
//
    @GET
    Observable<List<SupplierVResponse>> getSupplierV(@Url String mSupplierV);
//
//    @GET
//    Observable<STagDSearchResponse> getSTagD(@Url String mSTagD);
//
//    @POST
//    Observable<String> addSTagD(@Url String mSTagD, @Body STagDAddRequest mSTagDAddRequest);
//
//    @PUT
//    Observable<String> updateSTagD(@Url String mSTagD, @Body STagDAmendRequest mSTagDAmendRequest);
//
//    @GET
//    Observable<ITagDSearchResponse> getITagD(@Url String mITagD);
//
//    @GET
//    Observable<List<ITagDSearchResponse>> getITagDWithCondition(@Url String mITagD);
//
//    @GET
//    Observable<List<LTagDSearchResponse>> getLTagDWithCondition(@Url String mLTagD);
//
//    @GET
//    Observable<LTagDSearchResponse> getLTagDWithFullCondition(@Url String mLTagD);
//
//    @GET
//    Observable<List<STagDSearchResponse>> getSTagDWithCondition(@Url String mSTagD);
//
//    @GET
//    Observable<List<PTagDSearchResponse>> getPTagDWithCondition(@Url String mPTagD);
//
//    @GET
//    Observable<List<MPTagDSearchResponse>> getMPTagDWithCondition(@Url String mMPTagD);
//
//    @GET
//    Observable<List<MPTagDSearchResponse>> getMPTagD(@Url String mITagD);
//
//    @POST
//    Observable<Object> addMRTagD(@Url String mMRTagD, @Body MRTagDAddRequest mMRTagDAddRequest);
//
//    @POST
//    Observable<String> addITagD(@Url String mITagD, @Body ITagDAddRequest mITagDAddRequest);
//
//    @PUT
//    Observable<String> updateITagD(@Url String mITagD, @Body ITagDAmendRequest mITagDAmendRequest);
//
//    @GET
//    Observable<PTagDSearchResponse> getPTagD(@Url String mPTagD);
//
//    @POST
//    Observable<String> addPTagD(@Url String mPTagD, @Body PTagDAddRequest mPTagDAddRequest);
//
//    @PUT
//    Observable<String> updatePTagD(@Url String mPTagD, @Body PTagDAmendRequest mPTagDAmendRequest);
//
//    @PUT
//    Observable<String> updateOTagD(@Url String mOTagD, @Body OTagDAmendRequest mOTagDAmendRequest);
//    @GET
//    Observable<LTagDSearchResponse> getLTagD(@Url String mLTagD);
//
//    @POST
//    Observable<String> addOTagD(@Url String mOTagD, @Body OTagDAddRequest mOTagDAddRequest);
//    @GET
//    Observable<OTagDSearchResponse>getOTagD(@Url String mOTagD);
//
//    @GET
//    Observable<List<LTagDSearchResponse>> getLTagDOnMaterialID(@Url String mRequest);
//
//    @GET
//    Observable<List<LTagDSearchResponse>> getLTagDWithStorage(@Url String mLTagD);
//
//    @POST
//    Observable<String> addLTagD(@Url String mLTagD, @Body LTagDAddRequest mLTagDAddRequest);
//
//    @PUT
//    Observable<String> updateLTagD(@Url String mLTagD, @Body LTagDAmendRequest mLTagDAmendRequest);
//
//    @GET
//    Observable<List<TTagDSearchResponse>> getTTagD(@Url String mTTagD);
//
//    @POST
//    Observable<String> addTTagD(@Url String mTTagD, @Body TTagDAddRequest mTTagDAddRequest);
//
//    @POST
//    Observable<String> addTTagDResponse(@Url String mTTagD, @Body TTagDAddRequest mTTagDAddRequest);

    @GET
    Observable<PersonVResponse> getPersonV(@Url String mPersonV);

//    @GET
//    Observable<List<SSMasterVResponse>> getSSMasterV(@Url String mSSMasterV);
//
//    @GET
//    Observable<List<SSMasterV2Response>> getSSMasterV2(@Url String mSSMasterV2);
//
//    @GET
//    Observable<List<ScarpReasonResponse>> getScarpReason(@Url String reasonId);

}
