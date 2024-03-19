package edu.cnm.deepdive.sereknitty.service;


import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.sereknitty.model.dao.PatternDao;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import edu.cnm.deepdive.sereknitty.model.entity.User;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * Provides high-level operations on a repository of {@link Pattern} instances, backed by a SQLite
 * database, in turn accessed via {@link SereknittyDatabase}. This class has no mutable state, and
 * its methods are thread-safe; however, mutating operations (involving {@code INSERT},
 * {@code UPDATE}, or {@code DELETE} on the underlying database) attempted simultaneously could
 * block or fail.
 */
@Singleton
public class PatternRepository {

  private final PatternDao patternDao;


  /**
   * Initializes this instance by establishing a logical connection to the underlying database.
   */

  @Inject
  PatternRepository(PatternDao patternDao) {
    this.patternDao = patternDao;
  }

  /**
   * Returns a {@link LiveData}-based query for the {@link Pattern} entity instance identified by
   * {@code id}. The query executes when observed, or (if already being observed) whenever the
   * contents of the underlying {@code user} table are modified using Room data-access methods.
   *
   * @param id Unique identifier (primary key value) of a {@link Pattern} entity instance.
   * @return {@link LiveData}-based query for the {@link Pattern} identified by {@code id}.
   */
  public LiveData<Pattern> get(long id) {
    return patternDao.select(id);
  }

}
