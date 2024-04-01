package edu.cnm.deepdive.sereknitty.service;

import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.sereknitty.model.PatternWithRows;
import edu.cnm.deepdive.sereknitty.model.dao.PatternDao;
import edu.cnm.deepdive.sereknitty.model.dao.RowDao;
import edu.cnm.deepdive.sereknitty.model.dao.RowStitchDao;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import edu.cnm.deepdive.sereknitty.model.entity.Row;
import edu.cnm.deepdive.sereknitty.model.entity.RowStitch;
import edu.cnm.deepdive.sereknitty.model.pojo.PatternLocation;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.time.Instant;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
  private final RowDao rowDao;
  private final RowStitchDao rowStitchDao;

  /**
   * Initializes this instance by establishing a logical connection to the underlying database.
   */
  @Inject
  PatternRepository(PatternDao patternDao, RowDao rowDao, RowStitchDao rowStitchDao) {
    this.patternDao = patternDao;
    this.rowDao = rowDao;
    this.rowStitchDao = rowStitchDao;
  }

  /**
   * Returns a {@link LiveData}-based query for the {@link Pattern} entity instance identified by
   * {@code id}. The query executes when observed, or (if already being observed) whenever the
   * contents of the underlying {@code user} table are modified using Room data-access methods.
   *
   * @param id Unique identifier (primary key value) of a {@link Pattern} entity instance.
   * @return {@link LiveData}-based query for the {@link Pattern} identified by {@code id}.
   */
  public LiveData<PatternWithRows> getPattern(long id) {
    return patternDao.select(id);
  }

  /**
   * Returns a {@link LiveData}-based query of all {@link Pattern} entity instances. The query
   * executes when observed, or (if already being observed) whenever the contents of the underlying
   * {@code pattern} table are modified using Room data-access methods.
   */
  public LiveData<List<Pattern>> getAllPatterns() {
    return patternDao.select();
  }

  /**
   * @param patternId
   * @return
   */

  public LiveData<List<Row>> getRows(long patternId) {
    return rowDao.selectByPattern(patternId);
  }

  /**
   * @param rowId
   * @return
   */
  public LiveData<List<RowStitch>> getStitchesByRow(long rowId) {
    return rowStitchDao.selectForRow(rowId);
  }

  /**
   * Returns a {@link LiveData}-based query of a {@link PatternLocation} instance. The query
   * executes when observed, or (if already being observed) whenever the contents of the underlying
   * {@code pattern} table are modified using Room data-access methods.
   *
   * @param patternId Unique identifier (primary key value) of a {@link Pattern} entity instance.
   * @return {@link LiveData}-based query for the {@link PatternLocation} identified by
   * {@code patternId}.
   */
  public LiveData<PatternLocation> getLocation(long patternId) {
    return patternDao.getLocation(patternId);
  }

  /**
   * Constructs and returns a {@link Single} task that, when executed (subscribed to), will insert
   * or update the specified {@code pattern} in the database, and pass the updated {@link Pattern}
   * instance to the subscribing {@link io.reactivex.rxjava3.functions.Consumer}. The specific
   * persistence operation is determined by examining the value returned by {@link Pattern#getId()}:
   * a value of zero (0) indicates the {@code user} has not yet been {@code INSERT}ed and must be; a
   * non-zero value indicates that {@code user} is already in the database, and must thus be
   * {@code UPDATE}d.
   *
   * @param pattern Instance of {@link Pattern} entity class to be persisted (inserted or updated)
   *                in the database.
   * @return {@link Single} task that will persist {@code pattern} to the database when executed
   * (subscribed to).
   */
  public Single<Pattern> save(Pattern pattern) {
    return (
        (pattern.getId() == 0)
            ? insert(pattern)
            : update(pattern)
    )
        .subscribeOn(Schedulers.io());
  }

  public Single<Row> save(Row row) {
    return (
        (row.getId() == 0)
            ? insert(row)
            : update(row)
    )
        .subscribeOn(Schedulers.io());
  }

  public Single<RowStitch> save(RowStitch stitch) {
    return (
        (stitch.getId() == 0)
            ? insert(stitch)
            : update(stitch)
    )
        .subscribeOn(Schedulers.io());
  }

  public Single<Collection<RowStitch>> save(Collection<RowStitch> stitches) {
    return rowStitchDao
        .insert(stitches)
        .map((ids) -> {
          Iterator<Long> idIterator = ids.iterator();
          Iterator<RowStitch> stitchIterator = stitches.iterator();
          while (idIterator.hasNext()) {
            stitchIterator.next().setId(idIterator.next());
          }
          return stitches;
        })
        .subscribeOn(Schedulers.io());
  }

  /**
   * Constructs and returns a {@link Completable} task that, when executed (subscribed to), removes
   * the specified {@code pattern} from the database.
   *
   * @param pattern Instance of {@link Pattern} entity class to be deleted from the database.
   * @return {@link Completable} task that will delete {@code pattern} from the database when
   * executed (subscribed to).
   */
  public Completable delete(Pattern pattern) {
    return patternDao.delete(pattern)
        .ignoreElement()
        .subscribeOn(Schedulers.io());
  }


  private Single<Pattern> insert(Pattern pattern) {
    pattern.setCreated(Instant.now());
    return patternDao
        .insert(pattern)
        .map((id) -> {
          pattern.setId(id);
          return pattern;
        });

  }

  private Single<Pattern> update(Pattern pattern) {
    return patternDao
        .update(pattern)
        .map((count) -> pattern);
  }


  private Single<Row> insert(Row row) {
    return rowDao
        .insert(row)
        .map((id) -> {
          row.setId(id);
          return row;
        });
  }

  private Single<Row> update(Row row) {
    return rowDao
        .update(row)
        .map((count) -> row);
  }

  private Single<RowStitch> insert(RowStitch stitch) {
    return rowStitchDao
        .insert(stitch)
        .map((id) -> {
          stitch.setId(id);
          return stitch;
        });
  }

  private Single<RowStitch> update(RowStitch stitch) {
    return rowStitchDao
        .update(stitch)
        .map((count) -> stitch);
  }
}
