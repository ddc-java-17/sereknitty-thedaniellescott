/*
 *  Copyright 2024 CNM Ingenuity, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package edu.cnm.deepdive.sereknitty.service;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import edu.cnm.deepdive.sereknitty.model.Stitch;
import edu.cnm.deepdive.sereknitty.model.dao.PatternDao;
import edu.cnm.deepdive.sereknitty.model.dao.RowDao;
import edu.cnm.deepdive.sereknitty.model.dao.RowStitchDao;
import edu.cnm.deepdive.sereknitty.model.dao.UserDao;
import edu.cnm.deepdive.sereknitty.model.entity.Pattern;
import edu.cnm.deepdive.sereknitty.model.entity.Row;
import edu.cnm.deepdive.sereknitty.model.entity.RowStitch;
import edu.cnm.deepdive.sereknitty.model.entity.User;
import edu.cnm.deepdive.sereknitty.service.SereknittyDatabase.Converters;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.inject.Provider;

/**
 * Defines a connection to a local Room/SQLite database, All database reads/writes are performed
 * using data-access object (DAO) instances obtained from the singleton instance of this class.
 */
@Database(
    entities = {User.class, Pattern.class, Row.class, RowStitch.class},
    version = 1
)
@TypeConverters({Converters.class})
public abstract class SereknittyDatabase extends RoomDatabase {

  /**
   * Name of SQLite database file.
   */
  public static final String NAME = "sereknitty-database";

  SereknittyDatabase() {
    // Package-private constructor to avoid automatic HTML generation for Javadocs.
  }

  public static String getName() {
    return NAME;
  }

  /**
   * Returns an instance of a {@link UserDao} implementation, providing persistence operations on
   * instances of the {@link User} entity class.
   */
  public abstract UserDao getUserDao();

  /**
   * Returns an instance of a {@link PatternDao} implementation, providing persistence operations on
   * instances of the {@link Pattern } entity class.
   */
  public abstract PatternDao getPatternDao();

  /**
   * Returns an instance of a {@link RowDao} implementation, providing persistence operations on
   * instances of the {@link Row} entity class.
   */
  public abstract RowDao getRowDao();

  /**
   * Returns an instance of a {@link RowStitchDao} implementation, providing persistence operations on
   * instances of the {@link RowStitchDao} entity class.
   */
  public abstract RowStitchDao getRowStitchDao();


  /**
   * Defines converters for otherwise unsupported types (initially, just {@link Instant}) to one of
   * those supported by Room/SQLite.
   */
  public static class Converters {

    /**
     * Returns the specified {@link Instant} {@code value} as a {@link Long}, corresponding to the
     * number of milliseconds elapsed since {@code 1970-01-01 00:00:00+00:00} encapsulated within
     * {@code value}. When {@code value} is {@code null}, this method returns {@code null} as well.
     *
     * @param value Input {@link Instant}
     * @return Epoch milliseconds encapsulated in {@code value}.
     */
    @TypeConverter
    @Nullable
    public static Long toLong(@Nullable Instant value) {
      return (value != null) ? value.toEpochMilli() : null;
    }

    /**
     * Returns an {@link Instant} instance containing the specified {@link Long} {@code value} epoch
     * milliseconds. That is, {@code value} is interpreted as a number of milliseconds elapsed since
     * {@code 1970-01-01 00:00:00+00:00}, and the corresponding {@link Instant} is returned. When
     * {@code value} is {@code null}, this method returns {@code null} as well.
     *
     * @param value Epoch milliseconds.
     * @return {@link Instant} corresponding to {@code value}.
     */
    @TypeConverter
    @Nullable
    public static Instant toInstant(@Nullable Long value) {
      return (value != null) ? Instant.ofEpochMilli(value) : null;
    }

  }

  /**
   * Implements methods to be invoked on key database events.
   */
  public static class Callback extends RoomDatabase.Callback {

    private final Provider<PatternRepository> repositoryProvider;

    /**
     *
     *
     * @param repositoryProvider
     */
    public Callback(Provider<PatternRepository> repositoryProvider) {
      this.repositoryProvider = repositoryProvider;
    }


    @SuppressLint("CheckResult")
    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
      super.onCreate(db);
      PatternRepository repository = repositoryProvider.get();
      Row row = new Row();

      //noinspection SimplifyStreamApiCallChains
      List<RowStitch> stitches = Arrays.stream(Stitch.values())
          .map((stitch) -> {
            RowStitch rowStitch = new RowStitch();
            rowStitch.setOrdinalPosition(stitch.ordinal());
            return rowStitch;
          }
      )
          .collect(Collectors.toList());
      Pattern pattern = new Pattern();
      pattern.setPatternName("Stockinette");
      pattern.setPatternDescription("Testing");
      //noinspection ResultOfMethodCallIgnored
      repository.save(pattern)
          .doOnSuccess((p) -> row.setPatternId(p.getId()))
          .subscribe(
              (p) -> {
                row.setPatternId(p.getId());
                //noinspection ResultOfMethodCallIgnored
                repository.save(row)
                    .doOnSuccess((r) -> stitches.forEach((s) -> s.setRowId(r.getId())))
                    .subscribe(
                        (r) -> repository.save(stitches)
                            .subscribe()
                    );
              }
          );
      pattern = new Pattern();
      pattern.setPatternName("Garter");
      pattern.setPatternDescription("Testing here, too");
      repository.save(pattern).subscribe();
      // TODO Obtain DAO instances from database, and use them to perform any required preloads, e.g.
      //  LocalDatabase database = LocalDatabase.getInstance();
      //  etc.
    }

  }

}
