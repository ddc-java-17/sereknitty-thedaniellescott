package edu.cnm.deepdive.sereknitty.hilt;

import android.content.Context;
import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import edu.cnm.deepdive.sereknitty.model.dao.UserDao;
import edu.cnm.deepdive.sereknitty.service.SereknittyDatabase;
import javax.inject.Singleton;

/**
 * Uses Dagger {@link Provides @Provides}-annotated methods to satisfy dependencies on concrete
 * implementations of {@link SereknittyDatabase} and {@link UserDao}.
 */
@InstallIn(SingletonComponent.class)
@Module
public final class DatabaseModule {

  DatabaseModule() {
    // Package-private constructor to avoid automatic HTML documentation generation.
  }

  @Provides
  @Singleton
  SereknittyDatabase provideLocalDatabase(@ApplicationContext Context context) {
    return Room
        .databaseBuilder(context, SereknittyDatabase.class, SereknittyDatabase.NAME)
        .addCallback(new SereknittyDatabase.Callback())
        .build();
  }

  @Provides
  UserDao provideUserDao(SereknittyDatabase database) {
    return database.getUserDao();
  }

  // TODO Add additional methods so satisfy dependencies on other DAO interface implementations.

}
