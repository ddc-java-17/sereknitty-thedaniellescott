package edu.cnm.deepdive.sereknitty.service;


import edu.cnm.deepdive.sereknitty.model.dao.PatternDao;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
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
}
