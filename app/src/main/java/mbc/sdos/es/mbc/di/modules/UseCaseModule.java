package mbc.sdos.es.mbc.di.modules;

import com.path.android.jobqueue.JobManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mbc.sdos.es.mbc.domain.usecase.base.TaskSchedulerJobQueue;
import mbc.sdos.es.mbc.domain.usecase.base.UseCaseHandler;
import mbc.sdos.es.mbc.domain.usecase.base.UseCaseScheduler;

@Module
public class UseCaseModule {

    public UseCaseModule() {

    }

    @Provides
    @Singleton
    public UseCaseScheduler provideUseCaseScheluder(JobManager jobManager) {
        return new TaskSchedulerJobQueue(jobManager);
    }

    @Provides
    @Singleton
    public UseCaseHandler provideUseCaseHandler(UseCaseScheduler useCaseScheduler) {
        return new UseCaseHandler(useCaseScheduler);
    }
}
