(ns migrations.20130610204637-create-user-table
 (:use [korma.db] [korma.core]))

(defn up
  "Migrates the database up to version 20130610204637."
  []
  (exec-raw
    ["CREATE TABLE users (
     id bigserial primary key,
     email varchar(255) NOT NULL
     );"])
  (println "migrations.20130610204637-create-user-table up..."))

(defn down
  "Migrates the database down from version 20130610204637."
  []
  (exec-raw ["DROP TABLE users"])
  (println "migrations.20130610204637-create-user-table down..."))
