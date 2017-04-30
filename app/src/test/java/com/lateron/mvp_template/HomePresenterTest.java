package com.lateron.mvp_template;

import android.content.SharedPreferences;

import com.lateron.mvp_template.analytics.AnalyticsInterface;
import com.lateron.mvp_template.tasks.content.GetDashboardContentTask;
import com.lateron.mvp_template.tasks.content.GetHomeContentTask;
import com.lateron.mvp_template.tasks.content.GetNotificationContentTask;
import com.lateron.mvp_template.tasks.user.LogUserOutTask;
import com.lateron.mvp_template.ui.presenters.HomePresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.observers.DisposableObserver;

import static junit.framework.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class HomePresenterTest {

    @Mock
    private GetHomeContentTask getHomeContentTask;
    @Mock
    private GetDashboardContentTask getDashboardContentTask;
    @Mock
    private GetNotificationContentTask getNotificationContentTask;
    @Mock
    private LogUserOutTask logUserOutTask;
    @Mock
    private AnalyticsInterface analyticsInterface;
    @Mock
    private SharedPreferences sharedPreferences;

    @Mock
    private HomePresenter.View view;

    private HomePresenter homePresenter;
    private TestContentObserver testContentObserver;
    private boolean hasContent;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        homePresenter = new HomePresenter(getHomeContentTask,
                getDashboardContentTask,
                getNotificationContentTask,
                logUserOutTask,
                analyticsInterface,
                sharedPreferences);

    }

    @Test
    public void testViewBinding() {
        homePresenter.attachView(view);
        assertTrue(homePresenter.isViewAttached());
    }

    /*
    @Test
    public void testGetHomeContentTask() {

        testContentObserver = new TestContentObserver();

        TestScheduler testScheduler = new TestScheduler();
        when(getHomeContentTask.getObservable(ArgumentMatchers.any()))
                .thenReturn(Observable.just("Test"));

        getHomeContentTask.execute(testContentObserver, testScheduler, null);
        testScheduler.advanceTimeBy(5, TimeUnit.SECONDS);
        assertTrue(hasContent);


        assertEquals(getHomeContentTask.getDisposables().size(), 1);
        getHomeContentTask.dispose();
        assertTrue(testContentObserver.isDisposed());


    }
    */

    /*
    @Test public void testLoadingIsCalledCorrectly() {
        TestScheduler testScheduler = new TestScheduler();
        Observable result = getHomeContentTask.getObservable(null);

        homePresenter.attachView(view);
        testScheduler.triggerActions();
        verify(view, times(1)).
    */

    public final class TestContentObserver extends DisposableObserver<String> {

        @Override
        public void onComplete() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(String content) {
            hasContent = true;
        }
    }

}
