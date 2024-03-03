package edu.cnm.deepdive.sereknitty.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity
@Table(name = "pattern_manager", indexes = {
    @Index(columnList = "pattern_manager_id, user_id"),
})
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"pattern_manager_id"})
public class PatternManager {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "pattern_manager_id")
  private long id;




}
