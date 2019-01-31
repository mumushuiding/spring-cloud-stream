package com.lt.cloud.rxjava.subject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.ReplaySubject;

public class Demo_ReplaySubject {
    public static void main(String[] args) {
        //get an observer as did in earlier code
        ReplaySubject<Long> replaySubject=ReplaySubject.create();
        Observer<Long> observer=new Observer<Long>() {
            @Override
            public void onComplete() {
                System.out.println("It's Done");
            }
            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
            @Override
            public void onNext(Long value) {
                System.out.println(":"+value);
            }
            @Override
                public void onSubscribe(Disposable disposable) {
                System.out.println("onSubscribe");
            }
        };
        replaySubject.onNext(1l);
        replaySubject.onNext(2l);
        replaySubject.subscribe(observer);
        replaySubject.onNext(10l);
        replaySubject.onComplete();
    }
}
