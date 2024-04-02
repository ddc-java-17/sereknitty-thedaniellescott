package edu.cnm.deepdive.sereknitty.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.sereknitty.model.entity.Row;
import edu.cnm.deepdive.sereknitty.model.entity.RowStitch;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Collection;
import java.util.List;

/**
 * Provides CRUD operations on {@link RowStitch} entity instances. {@code CREATE}, {@code INSERT},
 * {@code UPDATE}, and {@code DELETE} operations are implemented as ReactiveX {@link Single} tasks,
 * which execute on subscription; some {@code SELECT} tasks are implemented using {@link LiveData}
 * queries, which execute on observation, or (if already being observed) on Room-based updates to
 * the underlying tables.
 */
@Dao
public interface RowStitchDao {

  /**
   * Constructs and returns a {@link Single} that, when executed (subscribed to), inserts
   * {@code rowStitch} into the database and invokes the subscribing {@link Consumer} with the
   * auto-generated primary key value of the inserted record.
   *
   * @param rowStitch {@link RowStitch} instance to be inserted.
   * @return {@link Single} that will (when subscribed to) insert {@code rowStitch} into the
   * database.
   */
  @Insert
  Single<Long> insert(RowStitch rowStitch);

  /**
   * Constructs and returns a {@link Single} that, when executed (subscribed to), inserts a
   * {@link Collection} of {@link RowStitch} into the database and invokes the subscribing
   * {@link Consumer} with the auto-generated primary key value of the inserted record.
   *
   * @param stitches {@link Collection} of {@link RowStitch} to be inserted.
   * @return {@link Single} of a {@link List}  inserted {@code stitches}.
   */
  @Insert
  Single<List<Long>> insert(Collection<RowStitch> stitches);

  /**
   * Constructs and returns a {@link Single} that, when executed (subscribed to), updates
   * {@code stitch} to the database.
   *
   * @param stitch {@link RowStitch} instance to be updated.
   * @return {@link Single} that will update {@code stitch} to the database.
   */
  @Update
  Single<Integer> update(RowStitch stitch);

  /**
   * Queries the database about a particular {@code rowStitch} in a certain ordinal position.
   *
   * @param position A position within a {@link Row}.
   * @return {@link LiveData} of the {@link RowStitch} in said ordinal {@code position}.
   */
  @Query("SELECT * FROM row_stitch WHERE ordinal_position = :position")
  LiveData<RowStitch> select(int position);

  /**
   * Queries the database for all the {@link RowStitch} instances in a particular {@link Row}.
   *
   * @param rowId Id for the {@link Row} in question.
   * @return {@link LiveData} of the {@link List} of stitches in that {@link Row}.
   */
  @Query("SELECT * FROM row_stitch WHERE row_id = :rowId ORDER BY ordinal_position")
  LiveData<List<RowStitch>> selectForRow(long rowId);

}
