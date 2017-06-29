package com.bawei.wangxueshi.fengzhuangmvpandretrofit.network;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.network.cookie.CookiesManager;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Administrator on 2017/6/19.
 */

public class RetrofitFactory {



    public static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .cookieJar(new CookiesManager())  // cook里有session，让服务器保持唯一
            .connectTimeout(20, TimeUnit.SECONDS)  //连接
            .readTimeout(20,TimeUnit.SECONDS)         //
            .writeTimeout(20,TimeUnit.SECONDS)         //
            .addInterceptor(new LoggingInterceptor())  //
            .build();                                   //


    public  static ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://qbh.2dyt.com")     //
            .addConverterFactory(ScalarsConverterFactory.create())//
            .client(okHttpClient)  //这里防止每次都产生一个okhttpclient
            //把 以前的 call 转化成 Observable
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //适配   接口方法的返回值为Observable（以前返回的是call  ）
            .build()  //创建 Retrofit
            .create(ApiService.class);   //用 Retrofit 的动态代理，创建接口对象；

    public  static Observable<String> get(String url){
        return apiService.get(url)  //url
                .subscribeOn(Schedulers.io())  //被观察者在子线程
                .observeOn(AndroidSchedulers.mainThread()); //观察者在主线程
    }

    public  static void get(String url, Observer<String> observer){
                    apiService.get(url)  //url
                .subscribeOn(Schedulers.io())  //被观察者在子线程
                .observeOn(AndroidSchedulers.mainThread()) //观察者在主线程
                .subscribe(observer);
    }

    public static Observable<String> get(String url, Map<String,String> map){

        return apiService.get(url,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
    public static void get(String url, Map<String,String> map,Observer<String> observer){

       apiService.get(url,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    public static Observable<String> post(String url,Map<String,String> map){
        return  apiService.post(url,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
    public static void post(String url,Map<String,String> map,Observer<String> observer){
          apiService.post(url,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }



}
