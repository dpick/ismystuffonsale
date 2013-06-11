(ns migrations.20130610210030-add-items-table
 (:use [korma.db] [korma.core]))

(defn up
  "Migrates the database up to version 20130610210030."
  []
  (exec-raw
    ["CREATE TABLE items (
       id bigserial primary key,
       title varchar(255) NOT NULL,
       users_id integer NOT NULL
     );"])
  (println "migrations.20130610210030-add-items-table up..."))

(defn down
  "Migrates the database down from version 20130610210030."
  []
  (exec-raw ["DROP TABLE items"])
  (println "migrations.20130610210030-add-items-table down..."))
