package com.nav.navigatorapp.service;

import com.nav.navigatorapp.pojo.request.LoginData;
import com.nav.navigatorapp.pojo.request.ReqLogin;
import com.nav.navigatorapp.pojo.request.ReqRegister;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface ApiInterface {
    @Headers("Authorization:eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MX0.By2r2BwheJsbrEGrHOaMQwrrmlY7wHVFzWtuEmv39fM")
    @POST("users-login")
    Call<LoginData> getLogin(@Body ReqLogin reqLogin);

    @Headers("Authorization:eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MX0.By2r2BwheJsbrEGrHOaMQwrrmlY7wHVFzWtuEmv39fM")
    @POST("register-user")
    Call<String> register(@Body ReqRegister reqRegister);

//    @POST("articleslist")
//    Call<ResArticlePagination> getArticlesForPagination(@Body ReqArticlePagination reqArticlePagination);
//
//    @POST("article")
//    Call<ResArticle> getArticle(@Body ReqArticle article);
//
//    @POST("register")
//    Call<ResRegisterUser> registerUser(@Body ReqRegisterUser user);
//
//    @POST("landing")
//    Call<ResArticleBannerCombined> getArticlesBannersCombined(@Body ReqArticleBannerCombine bannerCombine);
//
//    @POST("roleupdate")
//    Call<ResUpdateUserRole> updateUserRole(@Body ReqUpdateUserRole userRole);
//
//    @POST("saveactivity")
//    Call<ResArticleActivity> saveArticleActivity(@Body ReqArticleActivity articleActivity);
//
//    @POST("savequiz")
//    Call<ResQuiz> saveQuizAnswer(@Body ReqQuiz quiz);
//
//    @POST("savequizdoubleup")
//    Call<ResDoubleupQuiz> saveQuizAnswerDoubleup(@Body ReqDoubleupQuiz quiz);
//
//    @POST("getprofile")
//    Call<ResProfile> getProfile(@Body ReqViewProfile viewProfile);
//
//    @POST("getcities")
//    Call<ResCities> getCities(@Body ReqCity request);
//
//    @POST("getschools")
//    Call<ResSchools> getSchools(@Body ReqSchool request);
//
//    @POST("getlocations")
//    Call<ResSchoolLocations> getSchoolLocations(@Body ReqSchoolLocation request);
//
//    @POST("updateprofile")
//    Call<ResUpdateProfile> updateProfile(@Body ReqUpdateProfile updateProfile);
//
//    @GET
//    Call<ResSchool> getSchool(@Url String url);
//
//
//    @POST("levelmaster")
//    Call<ResLevelMaster> getLevelMaster(@Body ReqLevelMaster reqLevelMaster);
//
//    @POST("progresscard")
//    Call<ResProgressCard> getProgressCard(@Body ReqProgressCard reqProgressCard);
//
//    @POST("leaderboard")
//    Call<ResLeaderBoard> getLeaderboard(@Body ReqLeaderBoard reqLeaderBoard);
//
//    @POST("verifyreferral")
//    Call<ResVerifyReferral> verifyReferral(@Body ReqVerifyReferral reqVerifyReferral);
//
//    @POST("powerup")
//    Call<ResSubscribeDetails> getPowerupDetails(@Body ReqSubscribeDetails reqSubscribeDetails);
//
//    @POST("placeorder")
//    Call<ResPurchaseData> savePurchaseData(@Body ReqPurchaseData reqPurchaseData);
//
//    @POST("placedoubleuporder")
//    Call<ResDoubleupData> saveDoubleupData(@Body ReqDoubleupData reqDoubleupData);
//
//    @POST("gameuserprofile")
//    Call<ResQuizUserInfo> getUserInfo(@Body ReqQuizUserInfo reqQuizUserInfo);
//
//    @POST("gamecategories")
//    Call<ResQuizCategory> getQuizCategory(@Body ReqQuizUserInfo reqQuizUserInfo);
//
//
////    @Headers("x-api-key: U47Ef7dVQJ1uS4NXqNgTJ97upydtc27C9DDoIXSU")
//    @POST("getplansdetail")
//    Call<ResSubscriptionPlanDetails> getSubscriptionPlans(@Body ReqSubscriptionPlanDetails reqSubscriptionPlanDetails);
//
//    @POST("validatecoupon")
//    Call<ResSubscriptionCouponApply> validateCoupon(@Body ReqSubscriptionCouponApply reqSubscriptionCouponApply);
//
//    @POST("subscribeduserdata")
//    Call<ResSubscribedUserDetails> getSubscribedPlanDetails(@Body ReqSubscribedUser reqSubscribedUser);
//
//    @POST("gamestatistics")
//    Call<ResQuizStats> getQuizStatsDetails(@Body ReqQuizStats reqQuizStats);
//
//    @POST("gameshop")
//    Call<ResQuizShop> getQuizShopDetails(@Body ReqQuizShop reqQuizShop);
//
//    @POST("contactsync")
//    Call<ResContactSync> getContactSync(@Body RequestContactSync requestContactSync);
//
//    @POST("gameuserfriendlist")
//    Call<ResUserFriendList> getFriendList(@Body ReqUserFriendList reqUserFriendList);
//
//    @POST("creategame")
//    Call<ResGame> getGameDetails(@Body ReqGame reqGame);
//
//    @POST("gamequizsaveoption")
//    Call<ResGameQuiz> gameQuizSaveOption(@Body ReqGameQuiz reqGameQuiz);
//
//    @POST("completegame")
//    Call<ResCompleteGame> completeGame(@Body ReqGameQuiz reqGameQuiz);
//
//    @POST("sendchallange")
//    Call<ResSendChallenge> sendChallange(@Body ReqSendChallenge reqSendChallenge);
//
//    @POST("displayChallange")
//    Call<ReqQuizUserInfo> displayChallange(@Body ReqSendChallenge reqSendChallenge);
//
//    @POST("gameresults")
//    Call<ResQuizResult> displayResult(@Body ReqQuizUserInfo reqQuizUserInfo);
//
//    @POST("abortgame")
//    Call<ResCompleteGame> abortGame(@Body ReqGameQuiz reqGameQuiz);
}

