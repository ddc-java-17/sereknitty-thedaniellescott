package edu.cnm.deepdive.sereknitty.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import edu.cnm.deepdive.sereknitty.model.entity.Row;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Collection;
import java.util.List;

/**
 * Provides CRUD operations on {@link Row} entity instances. {@code CREATE}, {@code INSERT},
 * {@code UPDATE}, and {@code DELETE} operations are implemented as ReactiveX {@link Single} tasks,
 * which execute on subscription; some {@code SELECT} tasks are implemented using {@link LiveData}
 * queries, which execute on observation, or (if already being observed) on Room-based updates to
 * the underlying tables.
 */
@Dao
public interface RowDao {

  /**
   * Constructs and returns a {@link Single} that, when executed (subscribed to), inserts
   * {@code row} into the database and invokes the subscribing {@link Consumer} with the
   * auto-generated primary key value of the inserted record.
   *
   * @param row {@link Row} instance to be inserted.
   * @return {@link Single} that will (when subscribed to) insert {@code row} into the database.
   */
  @Insert
  Single<Long> insert(Row row);

  /**
   * Constructs and returns a {@link Single} that, when executed (subscribed to), inserts
   * {@code rows} into the database and invokes the subscribing {@link Consumer} with the
   * auto-generated primary key value of the inserted record.
   *
   * @param rows {@link Collection} of {@link Row} instances to be inserted.
   * @return {@link Single} of {@link List} of {@code id}s that will (when subscribed to) insert
   * {@code row} into the database.
   */
  @Insert
  Single<List<Long>> insert(Collection<Row> rows);

  /**
   * Queries the database with the {@code id} of a {@code row} and returns {@link LiveData} of the
   * matching {@link Row} instance.
   *
   * @param id Id for a particular {@link Row}.
   * @return {@link LiveData} of the corresponding {@link Row}.
   */
  @Query("SELECT * FROM 'row' WHERE row_id = :id")
  LiveData<Row> select(long id);

  /**
   * Queries the database with the {@code patternId} and returns the {@code rows} that make up that
   * {@code pattern}.
   *
   * @param patternId The id of a particular {@link Pattern}.
   * @return {@link LiveData} of a {@link List} of {@link Row} instances that make up the
   * {@link Pattern}.
   */
  @Query("SELECT * FROM `row` WHERE pattern_id = :patternId ORDER BY row_id")
  LiveData<List<Row>> selectByPattern(long patternId);

  /**
   * Updates a particular row.
   *
   * @param row {@link Row} instance to be updated.
   * @return {@link Single} of {@link Integer} indicating that the {@code row} was updated.
   */
  @Update
  Single<Integer> update(Row row);

  /**
   * Updates and passes through a particular row, to avoid repeated queries.
   *
   * @param row {@link Row} to be updated.
   * @return {@link Single} of the updated {@code row}.
   */
  default Single<Row> updateAndPassThrough(Row row) {
    return update(row)
        .map((count) -> row);
  }

  /**
   * Deletes a {@code row}.
   *
   * @param row {@link Row} instance to be deleted.
   * @return {@link Single} of {@link Integer} indicating that the {@code DELETE} operation was
   * successful.
   */
  @Delete
  Single<Integer> delete(Row row);

}
