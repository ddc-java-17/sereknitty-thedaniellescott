package edu.cnm.deepdive.sereknitty.hilt;

import android.content.Context;
import androidx.room.Dao;
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
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import edu.cnm.deepdive.sereknitty.model.entity.Row;
import edu.cnm.deepdive.sereknitty.model.entity.RowStitch;
import edu.cnm.deepdive.sereknitty.model.entity.User;
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
   * @param context {@link Context} is the global information from the activity that allows us to
   *                share information across multiple fragments
   * @return {@link SereknittyDatabase} This is the database for the app, and it stores and
   * organizes all information in the app.
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
   * @param database This is {@link SereknittyDatabase}, and it stores and organizes all information
   *                 in the app.
   * @return {@link UserDao} The {@link Dao} that is responsible for the queries relating to the
   * {@link User} instances.
   */
  @Provides
  @Singleton
  public UserDao provideUserDao(SereknittyDatabase database) {
    return database.getUserDao();
  }

  /**
   * Provides a single instance of {@link PatternDao}.
   *
   * @param database This is {@link SereknittyDatabase}, and it stores and organizes all information
   *                 in the app.
   * @return {@link PatternDao} The {@link Dao} that is responsible for the queries relating to the
   * {@link Pattern} instances.
   */
  @Provides
  @Singleton
  public PatternDao providePatternDao(SereknittyDatabase database) {
    return database.getPatternDao();
  }

  /**
   * Provides a single instance of {@link RowDao}.
   *
   * @param database This is {@link SereknittyDatabase}, and it stores and organizes all information
   *                 in the app.
   * @return {@link RowDao} The {@link Dao} that is responsible for the queries relating to the
   * {@link Row} instances.
   */
  @Provides
  @Singleton
  public RowDao provideRowDao(SereknittyDatabase database) {
    return database.getRowDao();
  }

  /**
   * Provides a single instance of {@link RowStitchDao}.
   *
   * @param database This is {@link SereknittyDatabase}, and it stores and organizes all information
   *                 in the app.
   * @return {@link RowStitchDao} The {@link Dao} that is responsible for the queries relating to
   * the {@link RowStitch} instances.
   */
  @Provides
  @Singleton
  public RowStitchDao provideRowStitchDao(SereknittyDatabase database) {
    return database.getRowStitchDao();
  }

}
