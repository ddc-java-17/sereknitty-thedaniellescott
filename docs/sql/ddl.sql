-- Generated 2024-04-02 11:02:53-0600 for database version 1

CREATE TABLE IF NOT EXISTS `user` (`user_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `external_key` BLOB, `created` INTEGER NOT NULL, `modified` INTEGER NOT NULL, `oauth_key` TEXT NOT NULL, `display_name` TEXT NOT NULL COLLATE NOCASE);

CREATE UNIQUE INDEX IF NOT EXISTS `index_user_oauth_key` ON `user` (`oauth_key`);

CREATE UNIQUE INDEX IF NOT EXISTS `index_user_display_name` ON `user` (`display_name`);

CREATE TABLE IF NOT EXISTS `pattern` (`pattern_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `external_key` BLOB, `created` INTEGER NOT NULL, `modified` INTEGER NOT NULL, `pattern_name` TEXT, `pattern_description` TEXT, `image` TEXT, `user_id` INTEGER, `current_row_id` INTEGER, FOREIGN KEY(`user_id`) REFERENCES `user`(`user_id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`current_row_id`) REFERENCES `row`(`row_id`) ON UPDATE NO ACTION ON DELETE CASCADE );

CREATE UNIQUE INDEX IF NOT EXISTS `index_pattern_pattern_id` ON `pattern` (`pattern_id`);

CREATE INDEX IF NOT EXISTS `index_pattern_created` ON `pattern` (`created`);

CREATE INDEX IF NOT EXISTS `index_pattern_modified` ON `pattern` (`modified`);

CREATE INDEX IF NOT EXISTS `index_pattern_pattern_name` ON `pattern` (`pattern_name`);

CREATE INDEX IF NOT EXISTS `index_pattern_user_id` ON `pattern` (`user_id`);

CREATE INDEX IF NOT EXISTS `index_pattern_current_row_id` ON `pattern` (`current_row_id`);

CREATE TABLE IF NOT EXISTS `row` (`row_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `current_stitch_id` INTEGER, `pattern_id` INTEGER NOT NULL, FOREIGN KEY(`pattern_id`) REFERENCES `pattern`(`pattern_id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`current_stitch_id`) REFERENCES `row_stitch`(`row_stitch_id`) ON UPDATE NO ACTION ON DELETE CASCADE );

CREATE INDEX IF NOT EXISTS `index_row_row_id` ON `row` (`row_id`);

CREATE INDEX IF NOT EXISTS `index_row_current_stitch_id` ON `row` (`current_stitch_id`);

CREATE INDEX IF NOT EXISTS `index_row_pattern_id` ON `row` (`pattern_id`);

CREATE TABLE IF NOT EXISTS `row_stitch` (`row_stitch_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `row_id` INTEGER NOT NULL, `ordinal_position` INTEGER NOT NULL, FOREIGN KEY(`row_id`) REFERENCES `row`(`row_id`) ON UPDATE NO ACTION ON DELETE NO ACTION );

CREATE INDEX IF NOT EXISTS `index_row_stitch_row_id` ON `row_stitch` (`row_id`);

CREATE INDEX IF NOT EXISTS `index_row_stitch_ordinal_position` ON `row_stitch` (`ordinal_position`);