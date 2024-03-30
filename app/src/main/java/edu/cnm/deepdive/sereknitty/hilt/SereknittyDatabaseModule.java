package edu.cnm.deepdive.sereknitty.hilt;

import android.content.Context;
import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import edu.cnm.deepdive.sereknitty.model.dao.PatternDao;
import edu.cnm.deepdive.sereknitty.model.dao.RowDao;
import edu.cnm.deepdive.sereknitty.model.dao.RowStitchDao;
import edu.cnm.deepdive.sereknitty.model.dao.UserDao;
import edu.cnm.deepdive.sereknitty.service.PatternRepository;
import edu.cnm.deepdive.sereknitty.service.SereknittyDatabase;
import javax.inject.Provider;
import javax.inject.Singleton;

/**
 * Uses Dagger {@link Provides @Provides}-annotated methods to satisfy dependencies on concrete
 * implementations of {@link SereknittyDatabase} and {@link UserDao}.
 */
@InstallIn(SingletonComponent.class)
@Module
public final class SereknittyDatabaseModule {

  SereknittyDatabaseModule() {
    // Package-private constructor to avoid automatic HTML documentation generation.
  }

  /**
   * Provides a single instance of {@link SereknittyDatabase}.
   *
   * @param context
   * @return {@link SereknittyDatabase}
   */
  @Provides
  @Singleton
  public SereknittyDatabase provideLocalDatabase(@ApplicationContext Context context,
      Provider<PatternRepository> repositoryProvider) {
    return Room
        .databaseBuilder(context, SereknittyDatabase.class, SereknittyDatabase.NAME)
        .addCallback(new SereknittyDatabase.Callback(repositoryProvider))
        .build();
  }

  /**
   * Provides a single instance of {@link UserDao}.
   *
   * @param database
   * @return {@link UserDao}
   */
  @Provides
  @Singleton
  public UserDao provideUserDao(SereknittyDatabase database) {
    return database.getUserDao();
  }

  /**
   * Provides a single instance of {@link PatternDao}.
   *
   * @param database
   * @return {@link PatternDao}
   */
  @Provides
  @Singleton
  public PatternDao providePatternDao(SereknittyDatabase database) {
    return database.getPatternDao();
  }

  /**
   * Provides a single instance of {@link RowDao}.
   *
   * @param database
   * @return {@link RowDao}
   */
  @Provides
  @Singleton
  public RowDao provideRowDao(SereknittyDatabase database) {
    return database.getRowDao();
  }

  /**
   * Provides a single instance of {@link RowStitchDao}.
   *
   * @param database
   * @return {@link RowStitchDao}
   */
  @Provides
  @Singleton
  public RowStitchDao provideRowStitchDao(SereknittyDatabase database) {
    return database.getRowStitchDao();
  }

}
